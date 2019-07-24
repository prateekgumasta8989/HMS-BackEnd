package com.app.pojos;

import javax.persistence.*;

@Embeddable
public class DocSchedule {
	int daysInWeek;
	double availableTime;
	double perPatientTime;
	String docStatus;
	
	public DocSchedule() {
		System.out.println("in the ctor DocSchedule()---------------------------");
	}

	public DocSchedule(int daysInWeek, double availableTime, double perPatientTime, String docStatus) {
		super();
		this.daysInWeek = daysInWeek;
		this.availableTime = availableTime;
		this.perPatientTime = perPatientTime;
		this.docStatus = docStatus;
	}

	@Column(name="days_in_week")
	public int getDaysInWeek() {
		return daysInWeek;
	}

	public void setDaysInWeek(int daysInWeek) {
		this.daysInWeek = daysInWeek;
	}

	@Column(name="per_day_available_time")
	public double getAvailableTime() {
		return availableTime;
	}

	public void setAvailableTime(double availableTime) {
		this.availableTime = availableTime;
	}
	
	@Column(name="per_patient_time")
	public double getPerPatientTime() {
		return perPatientTime;
	}

	public void setPerPatientTime(double perPatientTime) {
		this.perPatientTime = perPatientTime;
	}

	@Column(name="doc_status")
	public String getDocStatus() {
		return docStatus;
	}

	public void setDocStatus(String docStatus) {
		this.docStatus = docStatus;
	}

	@Override
	public String toString() {
		return "DocSchedule [daysInWeek=" + daysInWeek + ", availableTime=" + availableTime + ", perPatientTime="
				+ perPatientTime + ", docStatus=" + docStatus + "]";
	}
	
	
}
