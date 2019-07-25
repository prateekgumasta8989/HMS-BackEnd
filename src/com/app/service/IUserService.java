package com.app.service;

import java.util.List;

import com.app.dto.AppointmentDTO;
import com.app.dto.PatientDto;
import com.app.dto.User;
import com.app.pojos.DepartmentList;
import com.app.pojos.Doctors;

public interface IUserService {
	List<DepartmentList> getAllDepartment();
	List<Doctors> getDoctorDeptWise(int id);
	PatientDto registerAppointmentNew(AppointmentDTO appDto);
	List<PatientDto> getAllPatient();
	User validateAdmin(User u);
	User validatePatient(User u);
	User validateDoctor(User u);
	
	
}
