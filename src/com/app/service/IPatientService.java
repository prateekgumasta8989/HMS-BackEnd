package com.app.service;

import java.util.List;

import com.app.dto.AppointmentDTO;
import com.app.dto.DoctorDTO;
import com.app.dto.InvoiceDto;
import com.app.dto.PatientDto;
import com.app.patientdto.PatientDetailsDto;
import com.app.pojos.Doctors;

public interface IPatientService {
	String payInvoicesFromPatient(int invId);
	String payInvoicesFromPatientForAll(int patientId);
	List<InvoiceDto> getAllInvoicesForPatient(int patientId);
	List<AppointmentDTO> getAppointmentListByPatientId(int patientId);
	PatientDetailsDto getAllDetailsOfPatient(int id);
	DoctorDTO getDoctorPatient(int id);
	PatientDto registerAppointmentOld(AppointmentDTO appDto);
	PatientDto getPd(int pid);
}
