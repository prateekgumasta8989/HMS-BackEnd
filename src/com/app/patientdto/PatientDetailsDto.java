package com.app.patientdto;

import java.util.ArrayList;
import java.util.List;

public class PatientDetailsDto {
	String patientName;
	String patientGender;
	String patientBloodGroup;
	String patientContactInfo;
	String patientCaseStatus;

	
	List<PatientAppointmentDto> appointmentDto = new ArrayList<PatientAppointmentDto>();

	public PatientDetailsDto() {
		// TODO Auto-generated constructor stub
	}
	
	public String getPatientName() {
		return patientName;
	}


	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}


	public String getPatientGender() {
		return patientGender;
	}


	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}


	public String getPatientBloodGroup() {
		return patientBloodGroup;
	}


	public void setPatientBloodGroup(String patientBloodGroup) {
		this.patientBloodGroup = patientBloodGroup;
	}


	public String getPatientContactInfo() {
		return patientContactInfo;
	}


	public void setPatientContactInfo(String patientContactInfo) {
		this.patientContactInfo = patientContactInfo;
	}


	public String getPatientCaseStatus() {
		return patientCaseStatus;
	}


	public void setPatientCaseStatus(String patientCaseStatus) {
		this.patientCaseStatus = patientCaseStatus;
	}




	public List<PatientAppointmentDto> getAppointmentDto() {
		return appointmentDto;
	}

	public void setAppointmentDto(List<PatientAppointmentDto> appointmentDto) {
		this.appointmentDto = appointmentDto;
	}

	
	public PatientDetailsDto(String patientName, String patientGender, String patientBloodGroup,
			String patientContactInfo, String patientCaseStatus, List<PatientAppointmentDto> appointmentDto) {
		super();
		this.patientName = patientName;
		this.patientGender = patientGender;
		this.patientBloodGroup = patientBloodGroup;
		this.patientContactInfo = patientContactInfo;
		this.patientCaseStatus = patientCaseStatus;
		this.appointmentDto = appointmentDto;
	}

	@Override
	public String toString() {
		return "PatientDetailsDto [patientName=" + patientName + ", patientGender=" + patientGender
				+ ", patientBloodGroup=" + patientBloodGroup + ", patientContactInfo=" + patientContactInfo
				+ ", patientCaseStatus=" + patientCaseStatus + ", appointmentDto=" + appointmentDto + "]";
	}
	
	
}
