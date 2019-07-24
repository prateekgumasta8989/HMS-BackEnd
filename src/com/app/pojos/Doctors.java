package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="doctors")
public class Doctors {
	
	public Doctors() {
		System.out.println("in the ctor Doctors()---------------------------");
	}
	
	
	
	public Doctors(Integer id, String docName, String docContactInfo) {
		super();
		this.id = id;
		this.docName = docName;
		this.docContactInfo = docContactInfo;
	}

	Integer id;
	String docName;
	String docContactInfo;
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
	
		
	DocSchedule schedule;
	DepartmentList dept;
	List<AppointmentTable> appointmentList = new ArrayList<AppointmentTable>();
	
	@OneToMany(mappedBy="doctor",cascade=CascadeType.ALL)
	public List<AppointmentTable> getAppointmentList() {
		return appointmentList;
	}
	public void setAppointmentList(List<AppointmentTable> appointmentList) {
		this.appointmentList = appointmentList;
	}
	public void addAppointmentToDoctor(AppointmentTable appointment){
		this.appointmentList.add(appointment);
		appointment.setDoctor(this);
	}
	
	public void removeAppointmentFromDoctor(AppointmentTable appointment) {
		this.appointmentList.remove(appointment);
		appointment.setDoctor(null);
	}
	
	public void setDept(DepartmentList dept) {
		this.dept = dept;
	}
	
	
	@ManyToOne
	@JoinColumn(name="dept_id")
	public DepartmentList getDept() {
		return dept;
	}
	@Embedded	
	public DocSchedule getSchedule() {
		return schedule;
	}

	public void setSchedule(DocSchedule schedule) {
		this.schedule = schedule;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="doc_id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="doc_name",length=30)
	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	@Column(name="doc_contact",length=30)
	public String getDocContactInfo() {
		return docContactInfo;
	}

	public void setDocContactInfo(String docContactInfo) {
		this.docContactInfo = docContactInfo;
	}

	@Override
	public String toString() {
		return "Doctors [id=" + id + ", docName=" + docName + ", docContactInfo=" + docContactInfo + "]";
	}

}
