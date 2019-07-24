package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="patient_list")
public class Patient {
	Integer id;
	String patientName;
	String patientGender;
	String patientBloodGroup;
	String patientContactInfo;
	String patientCaseStatus;
	List<Invoices> invoicesOfPatient = new ArrayList<>();	
	List<AppointmentTable> appointment = new ArrayList<>();
	String email;
	String password;
	@Column(name="email",unique=true)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="pass")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public Patient(String patientName, String patientGender, String patientBloodGroup, String patientContactInfo) {
		super();
		this.patientName = patientName;
		this.patientGender = patientGender;
		this.patientBloodGroup = patientBloodGroup;
		this.patientContactInfo = patientContactInfo;
	}
	@OneToMany(mappedBy="patient",cascade=CascadeType.ALL)
	public List<AppointmentTable> getAppointment() {
		return appointment;
	}
	public void setAppointment(List<AppointmentTable> appointment) {
		this.appointment = appointment;
	}
	
	public void addAppointmentToPatient(AppointmentTable app){
		this.appointment.add(app);
		app.setPatient(this);
	}
	
	public void removeAppointmentFromPatient(AppointmentTable app) {
		this.appointment.remove(app);
		app.setPatient(null);
	}
	
	@JsonIgnore
	@OneToMany(mappedBy="patient",cascade=CascadeType.ALL)
	public List<Invoices> getInvoicesOfPatient() {
		return invoicesOfPatient;
	}
	public void setInvoicesOfPatient(List<Invoices> invoicesOfPatient) {
		this.invoicesOfPatient = invoicesOfPatient;
	}
	
	public void addInvoiceToPatient(Invoices inv) {
		this.invoicesOfPatient.add(inv);
		inv.setPatient(this);
	}
	
	public void removeInvoiceToPatient(Invoices inv) {
		this.invoicesOfPatient.remove(inv);
		inv.setPatient(null);
	}
	public Patient() {
		System.out.println("in the ctor Patient()---------------------------");
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="patient_id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="patient_name",length=20)
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	@Column(name="patient_gender",length=20)
	public String getPatientGender() {
		return patientGender;
	}
	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}
	@Column(name="patient_bg",length=20)
	public String getPatientBloodGroup() {
		return patientBloodGroup;
	}
	public void setPatientBloodGroup(String patientBloodGroup) {
		this.patientBloodGroup = patientBloodGroup;
	}
	@Column(name="patient_contact",length=20)
	public String getPatientContactInfo() {
		return patientContactInfo;
	}
	public void setPatientContactInfo(String patientContactInfo) {
		this.patientContactInfo = patientContactInfo;
	}
	@Column(name="patient_case_status",length=20)
	public String getPatientCaseStatus() {
		return patientCaseStatus;
	}
	public void setPatientCaseStatus(String patientCaseStatus) {
		this.patientCaseStatus = patientCaseStatus;
	}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", patientName=" + patientName + ", patientGender=" + patientGender
				+ ", patientBloodGroup=" + patientBloodGroup + ", patientContactInfo=" + patientContactInfo
				+ ", patientCaseStatus=" + patientCaseStatus + "]";
	}
	
	
}
