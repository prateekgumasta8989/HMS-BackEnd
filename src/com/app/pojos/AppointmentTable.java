package com.app.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="appointment_table")
public class AppointmentTable {
	public AppointmentTable() {
		System.out.println("in the ctor AppointmentTable()---------------------------");
	}
	
	Integer id;
	String problem;
	Date appointmentDate;
	int appointmentStatus;
	Doctors doctor;
	Patient patient;
	List<Prescription> prescriptions = new ArrayList<>();
	
	
	public AppointmentTable(String problem, Date appointmentDate, int appointmentStatus) {
		super();
		this.problem = problem;
		this.appointmentDate = appointmentDate;
		this.appointmentStatus = appointmentStatus;
	}
	
	
	@OneToMany(mappedBy="appointment",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public List<Prescription> getPrescriptions() {
		return prescriptions;
	}
	
	public void setPrescriptions(List<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}
	
	public void addPrescriptionToAppointment(Prescription p) {
		this.prescriptions.add(p);
		p.setAppointment(this);
	}
	
	
	public void removePrescriptionFromAppointment(Prescription p) {
		this.prescriptions.remove(p);
		p.setAppointment(null);
	}
	
	
	
	
	
	@ManyToOne
	@JoinColumn(name="patient_id")
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	
	@ManyToOne
	@JoinColumn(name="doctor_id")
	public Doctors getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctors doctor) {
		this.doctor = doctor;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="app_id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="app_problem",length=20)
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	@Column(name="app_date")
	@Temporal(TemporalType.DATE)
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	
	@Column(name="app_status")
	public int getAppointmentStatus() {
		return appointmentStatus;
	}
	public void setAppointmentStatus(int appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}
	@Override
	public String toString() {
		return "AppointmentTable [id=" + id + ", problem=" + problem + ", appointmentDate=" + appointmentDate
				+ ", appointmentStatus=" + appointmentStatus + "]";
	}
	
	
}
