package com.app.service;

import java.util.List;

import com.app.dto.AppointmentDTO;
import com.app.dto.InvoiceDto;
import com.app.dto.PatientDto;
import com.app.dto.PrescriptionDto;
import com.app.patientdto.PatientDetailsDto;
import com.app.pojos.Medicines;

public interface IDoctorService {
	List<AppointmentDTO> getAppointmentListByDocId(int docId);
	String acceptAppointmentOfPatient(int appId);
	List<PatientDto> getPatientByDoctorId(int id);
	List<InvoiceDto> getAllInvoicesForPatient(int patientId);
	List<Medicines> getAllMedicines();
	String registerPrescriptionWithAppointmentId(List<PrescriptionDto> listPrescr,int appId);
	PatientDetailsDto getAllDetailsOfPatient(int id);
	String registerInvoicesWithPrescription(List<PrescriptionDto> listPres,int appId);

}
