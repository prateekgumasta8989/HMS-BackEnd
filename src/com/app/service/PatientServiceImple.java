package com.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.print.Doc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IPatientDao;
import com.app.dto.AppointmentDTO;
import com.app.dto.DoctorDTO;
import com.app.dto.InvoiceDto;
import com.app.dto.PatientDto;
import com.app.patientdto.AppointmentPrescriptionDto;
import com.app.patientdto.PatientAppointmentDto;
import com.app.patientdto.PatientDetailsDto;
import com.app.pojos.AppointmentTable;
import com.app.pojos.Doctors;
import com.app.pojos.Invoices;
import com.app.pojos.Patient;
import com.app.pojos.Prescription;

@Repository
@Transactional
public class PatientServiceImple implements IPatientService{
	@Autowired
	private IPatientDao dao;
	
	public PatientServiceImple() {
		System.out.println("inside patient dao implementation");
	}
	
	
	
	@Override
	public List<AppointmentDTO> getAppointmentListByPatientId(int patientId) {
		return dao.getAppointmentListByPatientId(patientId);
	}

	
	@Override
	public String payInvoicesFromPatient(int invId) {
		return dao.payInvoicesFromPatient(invId);
	}


	@Override
	public String payInvoicesFromPatientForAll(int patientId) {
		return dao.payInvoicesFromPatientForAll(patientId);
	}

	
	@Override
	public List<InvoiceDto> getAllInvoicesForPatient(int patientId) {
		return dao.getAllInvoicesForPatient(patientId);
	}
	
	
	@Override
	public PatientDetailsDto getAllDetailsOfPatient(int id) {
		return dao.getAllDetailsOfPatient(id);
	}



	@Override
	public DoctorDTO getDoctorPatient(int id) {
		return dao.getDoctorPatient(id);
	}
	
	
	@Override
	public PatientDto registerAppointmentOld(AppointmentDTO appDto) {
		return dao.registerAppointmentOld(appDto);
	}



	@Override
	public PatientDto getPd(int pid) {
		return dao.getPd(pid);
	}
}
