package com.app.dto;

import java.util.Date;

public class AppointmentDTO {
	Integer id;
	String problem;
	Date appointmentDate;
	String patientName;
	String patientGender;
	String patientBloodGroup;
	String patientContactInfo;
	int deptId;
	int docId;
	String patientStatus;
	int appointmentStatus;
	String docName;
	String deptName;
	
	
	public AppointmentDTO(Integer id, String problem, Date appointmentDate, String patientName, String patientGender,
			String patientBloodGroup, String patientContactInfo, int deptId, int docId, String patientStatus,
			int appointmentStatus, String docName, String deptName) {
		super();
		this.id = id;
		this.problem = problem;
		this.appointmentDate = appointmentDate;
		this.patientName = patientName;
		this.patientGender = patientGender;
		this.patientBloodGroup = patientBloodGroup;
		this.patientContactInfo = patientContactInfo;
		this.deptId = deptId;
		this.docId = docId;
		this.patientStatus = patientStatus;
		this.appointmentStatus = appointmentStatus;
		this.docName = docName;
		this.deptName = deptName;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public AppointmentDTO(Integer id, String problem, Date appointmentDate, String patientName, String patientGender,
			String patientBloodGroup, String patientContactInfo, int deptId, int docId, String patientStatus,
			int appointmentStatus) {
		super();
		this.id = id;
		this.problem = problem;
		this.appointmentDate = appointmentDate;
		this.patientName = patientName;
		this.patientGender = patientGender;
		this.patientBloodGroup = patientBloodGroup;
		this.patientContactInfo = patientContactInfo;
		this.deptId = deptId;
		this.docId = docId;
		this.patientStatus = patientStatus;
		this.appointmentStatus = appointmentStatus;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getPatientStatus() {
		return patientStatus;
	}

	public void setPatientStatus(String patientStatus) {
		this.patientStatus = patientStatus;
	}

	public int getAppointmentStatus() {
		return appointmentStatus;
	}

	public void setAppointmentStatus(int appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}

	public AppointmentDTO(Integer id, String problem, Date appointmentDate, String patientName, String patientGender,
			String patientBloodGroup, String patientContactInfo, int deptId, int docId, String patientStatus) {
		super();
		this.id = id;
		this.problem = problem;
		this.appointmentDate = appointmentDate;
		this.patientName = patientName;
		this.patientGender = patientGender;
		this.patientBloodGroup = patientBloodGroup;
		this.patientContactInfo = patientContactInfo;
		this.deptId = deptId;
		this.docId = docId;
		this.patientStatus = patientStatus;
	}

	public AppointmentDTO() {
		// TODO Auto-generated constructor stub
	}

	public AppointmentDTO(Integer id, String problem, Date appointmentDate, String patientName, String patientGender,
			String patientBloodGroup, String patientContactInfo, int deptId, int docId) {
		super();
		this.id = id;
		this.problem = problem;
		this.appointmentDate = appointmentDate;
		this.patientName = patientName;
		this.patientGender = patientGender;
		this.patientBloodGroup = patientBloodGroup;
		this.patientContactInfo = patientContactInfo;
		this.deptId = deptId;
		this.docId = docId;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
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

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	@Override
	public String toString() {
		return "AppointmentDTO [id=" + id + ", problem=" + problem + ", appointmentDate=" + appointmentDate
				+ ", patientName=" + patientName + ", patientGender=" + patientGender + ", patientBloodGroup="
				+ patientBloodGroup + ", patientContactInfo=" + patientContactInfo + ", deptId=" + deptId + ", docId="
				+ docId + ", patientStatus=" + patientStatus + ", appointmentStatus=" + appointmentStatus + "]";
	}


	
	
	
}
