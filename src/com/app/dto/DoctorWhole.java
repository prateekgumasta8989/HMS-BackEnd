package com.app.dto;

public class DoctorWhole {
	Integer id;
	String docName;
	String docContactInfo;
	int daysInWeek;
	double availableTime;
	double perPatientTime;
	String docStatus;
	
	public DoctorWhole() {
		// TODO Auto-generated constructor stub
	}
	
	

	public DoctorWhole(Integer id, String docName, String docContactInfo, int daysInWeek, double availableTime,
			double perPatientTime, String docStatus) {
		super();
		this.id = id;
		this.docName = docName;
		this.docContactInfo = docContactInfo;
		this.daysInWeek = daysInWeek;
		this.availableTime = availableTime;
		this.perPatientTime = perPatientTime;
		this.docStatus = docStatus;
	}

	

	@Override
	public String toString() {
		return "DoctorWhole [id=" + id + ", docName=" + docName + ", docContactInfo=" + docContactInfo + ", daysInWeek="
				+ daysInWeek + ", availableTime=" + availableTime + ", perPatientTime=" + perPatientTime
				+ ", docStatus=" + docStatus + "]";
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDocContactInfo() {
		return docContactInfo;
	}

	public void setDocContactInfo(String docContactInfo) {
		this.docContactInfo = docContactInfo;
	}

	public int getDaysInWeek() {
		return daysInWeek;
	}

	public void setDaysInWeek(int daysInWeek) {
		this.daysInWeek = daysInWeek;
	}

	public double getAvailableTime() {
		return availableTime;
	}

	public void setAvailableTime(double availableTime) {
		this.availableTime = availableTime;
	}

	public double getPerPatientTime() {
		return perPatientTime;
	}

	public void setPerPatientTime(double perPatientTime) {
		this.perPatientTime = perPatientTime;
	}

	public String getDocStatus() {
		return docStatus;
	}

	public void setDocStatus(String docStatus) {
		this.docStatus = docStatus;
	}
	
	
}
