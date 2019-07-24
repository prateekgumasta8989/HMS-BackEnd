package com.app.patientdto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PatientAppointmentDto {
	Integer id;
	String problem;
	Date appointmentDate;
	int appointmentStatus;
	
	List<AppointmentPrescriptionDto> prescriptionDto = new ArrayList<AppointmentPrescriptionDto>();
	
	public PatientAppointmentDto() {
		// TODO Auto-generated constructor stub
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

	public int getAppointmentStatus() {
		return appointmentStatus;
	}

	public void setAppointmentStatus(int appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}


	@Override
	public String toString() {
		return "PatientAppointmentDto [id=" + id + ", problem=" + problem + ", appointmentDate=" + appointmentDate
				+ ", appointmentStatus=" + appointmentStatus + ", prescriptionDto=" + prescriptionDto + "]";
	}

	public PatientAppointmentDto(Integer id, String problem, Date appointmentDate, int appointmentStatus,
			List<AppointmentPrescriptionDto> prescriptionDto) {
		super();
		this.id = id;
		this.problem = problem;
		this.appointmentDate = appointmentDate;
		this.appointmentStatus = appointmentStatus;
		this.prescriptionDto = prescriptionDto;
	}

	public List<AppointmentPrescriptionDto> getPrescriptionDto() {
		return prescriptionDto;
	}

	public void setPrescriptionDto(List<AppointmentPrescriptionDto> prescriptionDto) {
		this.prescriptionDto = prescriptionDto;
	}
	
	
}
