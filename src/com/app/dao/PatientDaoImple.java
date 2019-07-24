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
import com.app.patientdto.AppointmentPrescriptionDto;
import com.app.patientdto.PatientAppointmentDto;
import com.app.patientdto.PatientDetailsDto;
import com.app.pojos.AppointmentTable;
import com.app.pojos.Invoices;
import com.app.pojos.Patient;
import com.app.pojos.Prescription;

@Repository
@Transactional
public class PatientDaoImple implements IPatientDao{
	@Autowired
	private SessionFactory sf;
	
	public PatientDaoImple() {
		System.out.println("inside patient dao implementation");
	}
	
	
	
	@Override
	public List<AppointmentDTO> getAppointmentListByPatientId(int patientId) {
		Session session = sf.getCurrentSession();
		Patient p =session.get(Patient.class, patientId);
		p.getAppointment().size();
		List<AppointmentDTO> list = new ArrayList<>();
		for (AppointmentTable app : p.getAppointment()) {
			list.add(new AppointmentDTO(app.getId(), app.getProblem(), app.getAppointmentDate(), p.getPatientName(), p.getPatientGender(), p.getPatientBloodGroup(), p.getPatientContactInfo(), 0, 0, p.getPatientCaseStatus(),app.getAppointmentStatus()));
		}
		return list;
	}

	
	@Override
	public String payInvoicesFromPatient(int invId) {
		Session session = sf.getCurrentSession();
		Invoices invoices = session.get(Invoices.class, invId);
		invoices.setStatus("paid");
		return null;
	}


	@Override
	public String payInvoicesFromPatientForAll(int patientId) {
		Patient patient = sf.getCurrentSession().get(Patient.class, patientId);
		patient.getInvoicesOfPatient().size();
		List<Invoices> invoices = patient.getInvoicesOfPatient();
		for (Invoices invoices2 : invoices) {
			invoices2.setStatus("paid");
		}
		return "updated";
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
