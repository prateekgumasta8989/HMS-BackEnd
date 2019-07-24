package com.app.dto;

public class PatientDto {
	Integer id;
	String patientName;
	String patientGender;
	String patientBloodGroup;
	String patientContactInfo;
	String patientCaseStatus;
	String email;
	String password;
	
	public PatientDto() {
		// TODO Auto-generated constructor stub
	}
	public PatientDto(Integer id, String patientName, String patientGender, String patientBloodGroup,
			String patientContactInfo, String patientCaseStatus, String email, String password) {
		super();
		this.id = id;
		this.patientName = patientName;
		this.patientGender = patientGender;
		this.patientBloodGroup = patientBloodGroup;
		this.patientContactInfo = patientContactInfo;
		this.patientCaseStatus = patientCaseStatus;
		this.email = email;
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "PatientDto [id=" + id + ", patientName=" + patientName + ", patientGender=" + patientGender
				+ ", patientBloodGroup=" + patientBloodGroup + ", patientContactInfo=" + patientContactInfo
				+ ", patientCaseStatus=" + patientCaseStatus + "]";
	}
	
	
}
