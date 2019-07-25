package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.dto.AppointmentDTO;
import com.app.dto.PatientDto;
import com.app.dto.User;
import com.app.pojos.Admin;
import com.app.pojos.AppointmentTable;
import com.app.pojos.DepartmentList;
import com.app.pojos.Doctors;
import com.app.pojos.Patient;

@Repository
@Transactional
public class UserServiceImple implements IUserService{

	

	@Autowired
	private IUserDao dao;

	public UserServiceImple() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<DepartmentList> getAllDepartment() {
		return dao.getAllDepartment();
	}
	@Override
	public List<Doctors> getDoctorDeptWise(int id) {
		return dao.getDoctorDeptWise(id);
	}

	
	@Override
	public PatientDto registerAppointmentNew(AppointmentDTO appDto) {
		return dao.registerAppointmentNew(appDto); 
	}
	


	
	@Override
	public List<PatientDto> getAllPatient() {
		return dao.getAllPatient();
	}
	@Override
	public User validateAdmin(User u) {
		return dao.validateAdmin(u);
	}


	@Override
	public User validatePatient(User u) {
		return dao.validatePatient(u);
	}


	@Override
	public User validateDoctor(User u) {
		return dao.validateDoctor(u);
	}

}
