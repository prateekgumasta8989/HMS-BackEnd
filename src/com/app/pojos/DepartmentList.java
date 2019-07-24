package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="dept_list")
public class DepartmentList {
	public DepartmentList() {
		System.out.println("in the ctor DepartmentList()---------------------------");
	}

	
	Integer Id;	
	String deptName;
	List<Doctors> doctors = new ArrayList<Doctors>();
	
	public void addDoctorToDepartment(Doctors d) {
		doctors.add(d);
		d.setDept(this);
	}
	
	public void removeDoctorFromDepartment(Doctors d){
		doctors.remove(d);
		d.setDept(null);
	}
	
	@JsonIgnore
	@OneToMany(mappedBy="dept",cascade=CascadeType.ALL)
	public List<Doctors> getDoctors() {
		return doctors;
	}

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="dept_id")
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	@Column(name="dept_name")
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "DepartmentList [Id=" + Id + ", DepartmentList=" + deptName + "]";
	}

	public void setDoctors(List<Doctors> doctors) {
		this.doctors = doctors;
	}
	
	
}
