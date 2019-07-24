package com.app.dao;

import java.util.List;

import com.app.dto.AppointmentDTO;
import com.app.dto.InvoiceDto;
import com.app.patientdto.PatientDetailsDto;

public interface IPatientDao {
	String payInvoicesFromPatient(int invId);
	String payInvoicesFromPatientForAll(int patientId);
	List<InvoiceDto> getAllInvoicesForPatient(int patientId);
	List<AppointmentDTO> getAppointmentListByPatientId(int patientId);
	PatientDetailsDto getAllDetailsOfPatient(int id);
}
