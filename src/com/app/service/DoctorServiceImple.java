package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IDoctorDao;
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

@Service
@Transactional
public class DoctorServiceImple implements IDoctorService
{
	@Autowired
	private IDoctorDao dao;
	
	public DoctorServiceImple() {
		System.out.println("inside doctor dao implementation");
	}
	
	
	
	
	@Override
	public String acceptAppointmentOfPatient(int appId) {
		return dao.acceptAppointmentOfPatient(appId);
	}
	
	
	@Override
	public List<PatientDto> getPatientByDoctorId(int id) {
		return dao.getPatientByDoctorId(id);
	}
	
	
	@Override
	public List<AppointmentDTO> getAppointmentListByDocId(int docId) {
		return dao.getAppointmentListByDocId(docId);
	}
	
	
	
	@Override
	public List<InvoiceDto> getAllInvoicesForPatient(int patientId) {
		return dao.getAllInvoicesForPatient(patientId);
	}
	
	
	
	@Override
	public List<Medicines> getAllMedicines() {
		return dao.getAllMedicines();
	}
	
	
	@Override
	public String registerPrescriptionWithAppointmentId(List<PrescriptionDto> listPrescr, int  id) {
		return dao.registerPrescriptionWithAppointmentId(listPrescr, id);
	}
	
	@Override
	public String registerInvoicesWithPrescription(List<PrescriptionDto> listPrescr,int appId) {
		return dao.registerInvoicesWithPrescription(listPrescr, appId);
	}

	
	@Override
	public PatientDetailsDto getAllDetailsOfPatient(int id) {
		return dao.getAllDetailsOfPatient(id);
	}

}
