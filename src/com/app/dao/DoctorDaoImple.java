package com.app.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.AppointmentDTO;
import com.app.dto.InvoiceDto;
import com.app.dto.PatientDto;
import com.app.dto.PrescriptionDto;
import com.app.patientdto.AppointmentPrescriptionDto;
import com.app.patientdto.PatientAppointmentDto;
import com.app.patientdto.PatientDetailsDto;
import com.app.pojos.AppointmentTable;
import com.app.pojos.Doctors;
import com.app.pojos.Invoices;
import com.app.pojos.Medicines;
import com.app.pojos.Patient;
import com.app.pojos.Prescription;

@Repository
@Transactional
public class DoctorDaoImple implements IDoctorDao
{
	@Autowired
	private SessionFactory sf;
	
	public DoctorDaoImple() {
		System.out.println("inside doctor dao implementation");
	}
	
	
	
	
	@Override
	public String acceptAppointmentOfPatient(int appId) {
		Session session = sf.getCurrentSession();
		AppointmentTable appPojo = session.get(AppointmentTable.class, appId);
		appPojo.setAppointmentStatus(1);
		Patient patient = session.get(Patient.class, appPojo.getPatient().getId());
		patient.addInvoiceToPatient(new Invoices("appointment charge", "unpaid", 250));
		return "updated";
	}
	
	
	@Override
	public List<PatientDto> getPatientByDoctorId(int id) {
		Session session = sf.getCurrentSession();
		Doctors d = session.get(Doctors.class, id);
		d.getAppointmentList().size();
		List<PatientDto> l1 = new ArrayList<>();
		for (AppointmentTable app : d.getAppointmentList()) {
			System.out.println("app=----->"  +  app);
			l1.add(new PatientDto(app.getPatient().getId(), app.getPatient().getPatientName(), app.getPatient().getPatientGender(), app.getPatient().getPatientBloodGroup(), app.getPatient().getPatientContactInfo(), app.getPatient().getPatientCaseStatus(), null,null));
		}
		System.out.println("in dao======================-");
		
		
		return l1;
		
	}
	
	
	@Override
	public List<AppointmentDTO> getAppointmentListByDocId(int docId) {
		Session session = sf.getCurrentSession();
		Doctors d = session.get(Doctors.class, docId);
		d.getAppointmentList().size();
		List<AppointmentDTO> l1 = new ArrayList<>();
		for (AppointmentTable app : d.getAppointmentList()) {
			System.out.println("app=----->"  +  app);
			System.out.println("patient ====> " + app.getPatient());
			l1.add(new AppointmentDTO(app.getId(),app.getProblem(), app.getAppointmentDate(), app.getPatient().getPatientName(), app.getPatient().getPatientGender(), app.getPatient().getPatientBloodGroup(), app.getPatient().getPatientContactInfo(), app.getDoctor().getDept().getId(), app.getDoctor().getId(),app.getPatient().getPatientCaseStatus(),app.getAppointmentStatus()));
		}
		System.out.println("in dao======================-");
		for (AppointmentDTO appointmentDTO : l1) {
			System.out.println(appointmentDTO);
		}
		
		return l1;
	}
	
	
	
	@Override
	public List<InvoiceDto> getAllInvoicesForPatient(int patientId) {
		Patient patient = sf.getCurrentSession().get(Patient.class, patientId);
		patient.getInvoicesOfPatient().size();
		List<InvoiceDto> invoiceDtos= new ArrayList<>();
		for (Invoices invoices : patient.getInvoicesOfPatient()) {
			invoiceDtos.add(new InvoiceDto(invoices.getInvoiceId(), invoices.getDescription(), invoices.getStatus(), invoices.getPrice(), invoices.getPatient().getId(), invoices.getPatient().getPatientName()));
		}
		return invoiceDtos;
	}
	
	
	
	@Override
	public List<Medicines> getAllMedicines() {
		String jpql = "select m from Medicines m";
		List<Medicines> l1 = sf.getCurrentSession().createQuery(jpql, Medicines.class).getResultList();
		for (Medicines medicines : l1) {
			System.out.println("------------------");
			System.out.println(medicines);
		}
		l1.size();
		return l1;
	}
	
	
	@Override
	public String registerPrescriptionWithAppointmentId(List<PrescriptionDto> listPrescr, int  id) {
		Session session = sf.getCurrentSession();
		for (PrescriptionDto prescriptionDto : listPrescr) {
			Prescription prescription = new Prescription(prescriptionDto.getNoOfDaysTake(), prescriptionDto.getWhenTake(), prescriptionDto.getWhenMeal());
			AppointmentTable appointmentTable = session.get(AppointmentTable.class, id);
			int medId = prescriptionDto.getMedID();
			Medicines med = session.get(Medicines.class, medId);
			prescription.setMedicines(med);
			appointmentTable.addPrescriptionToAppointment(prescription);
			
		}
		return "added";
	}
	
	@Override
	public String registerInvoicesWithPrescription(List<PrescriptionDto> listPrescr,int appId) {
		Session session = sf.getCurrentSession();
		AppointmentTable appPojo = session.get(AppointmentTable.class, appId);
		Patient patient = session.get(Patient.class, appPojo.getPatient().getId());
		for (PrescriptionDto prescriptionDto : listPrescr) {
			Medicines med = session.get(Medicines.class, prescriptionDto.getMedID());
			patient.addInvoiceToPatient(new Invoices("medicine " + med.getMedName(), "unpaid",med.getMedPrice()));
		}	
		
		
		return "updated";
	}

	
	@Override
	public PatientDetailsDto getAllDetailsOfPatient(int id) {
		Session session = sf.getCurrentSession();
		PatientDetailsDto patientDetailsDto = new PatientDetailsDto();
		Patient patient = session.get(Patient.class, id);
		patientDetailsDto.setPatientName(patient.getPatientName());
		patientDetailsDto.setPatientGender(patient.getPatientGender());
		patientDetailsDto.setPatientBloodGroup(patient.getPatientBloodGroup());
		patientDetailsDto.setPatientContactInfo(patient.getPatientContactInfo());
		patientDetailsDto.setPatientCaseStatus(patient.getPatientCaseStatus());
		patientDetailsDto.setPatientName(patient.getPatientName());
		
		patient.getAppointment().size();
		List<PatientAppointmentDto> appointmentDtos = new ArrayList<>();
		for (AppointmentTable app : patient.getAppointment()) {
			app.getPrescriptions().size();
			if(app.getPrescriptions().size() != 0)
			{
				PatientAppointmentDto appointmentDto = new PatientAppointmentDto();
				appointmentDto.setId(app.getId());
				appointmentDto.setProblem(app.getProblem());
				appointmentDto.setAppointmentDate(app.getAppointmentDate());
				appointmentDto.setAppointmentStatus(app.getAppointmentStatus());
				List<AppointmentPrescriptionDto> presList = new ArrayList<>();	
				app.getPrescriptions().size();
				for (Prescription prescription : app.getPrescriptions()) {
					prescription.getMedicines();
					if( prescription.getMedicines() != null) {
						presList.add(new AppointmentPrescriptionDto(prescription.getId(), prescription.getNoOfDaysToTake(), prescription.getWhenTake(), prescription.getBeforeAfterMeal(), prescription.getMedicines().getMedID(), prescription.getMedicines().getMedName(), prescription.getMedicines().getMedCategory(), prescription.getMedicines().getMedPrice()));	
					}
					
				}
				appointmentDto.setPrescriptionDto(presList);
				appointmentDtos.add(appointmentDto);
			}
		}
			
		patientDetailsDto.setAppointmentDto(appointmentDtos);
		System.out.println("IN  DAOOOO ================================================");
		System.out.println(patientDetailsDto);
		return patientDetailsDto;
	}

}
