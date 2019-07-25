package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AppointmentDTO;
import com.app.dto.Department;
import com.app.dto.DoctorDTO;
import com.app.dto.PatientDto;
import com.app.dto.User;
import com.app.pojos.DepartmentList;
import com.app.pojos.Doctors;
import com.app.service.IUserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

	@Autowired
	IUserService userService;
	
	public UserController() {
		System.out.println("inside the constructor of user Controller");
	}
	
	@GetMapping("/dept")
	public ResponseEntity<?> getAllDeptList(){
		System.out.println(" getAllDeptList() in /admin/dept");
		List<DepartmentList> l1 = userService.getAllDepartment();
		List<Department> l2 = new ArrayList<>();
		if(l1.size() != 0)
		{
			for (DepartmentList departmentList : l1) {
				l2.add(new Department(departmentList.getId(),departmentList.getDeptName()));
				System.out.println(departmentList);
				
		}
			return new ResponseEntity<List<Department>>(l2, HttpStatus.OK);
			
		}
		return new ResponseEntity<String>("not even a single department", HttpStatus.OK);
	}
	
	
	@GetMapping("/doctor/{id}")
	public ResponseEntity<?> allDoctorDepartmentWise(@PathVariable(name="id") int id){		
		System.out.println("allDoctorDepartmentWise() in /admin/doc------------");
		List<Doctors> l1Doc = userService.getDoctorDeptWise(id);
		List<DoctorDTO> l2DcoDto = new ArrayList<>();
		if(l1Doc.size() != 0)
		{
			for (Doctors d : l1Doc) {
				l2DcoDto.add(new DoctorDTO(d.getId(), d.getDocName(), d.getDocContactInfo(),d.getDept().getDeptName()));
			}
			return new ResponseEntity<List<DoctorDTO>>(l2DcoDto, HttpStatus.OK);
		}
		return new ResponseEntity<String>("not even a single doctors", HttpStatus.OK);
	}
	
	
	@PostMapping("/app/new")
	public ResponseEntity<?> addAppointmentNew(@RequestBody AppointmentDTO appDto){
		
		System.out.println("in controller appointment app ");
		System.out.println("addAppointmentNew() in /admin/app------------"  + appDto);

		try {
			return new ResponseEntity<PatientDto>(userService.registerAppointmentNew(appDto), HttpStatus.OK);
		}catch(RuntimeException re) {
			return new ResponseEntity<String>("not added successfully", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
		
	@GetMapping("/patient")
	public ResponseEntity<?> getAllPatient() {
		System.out.println("getAllPatient() in /admin/patient");
		List<PatientDto> l2 =  userService.getAllPatient();
		try {
			return new ResponseEntity<List<PatientDto>>(l2, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<String>("not even a single department" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> onLogin(@RequestBody User user){
		try {
			if(user.getRole().equals("Admin")) {
				return new ResponseEntity<User>(userService.validateAdmin(user), HttpStatus.OK);
			} else if(user.getRole().equals("Patient")) {
				return new ResponseEntity<User>(userService.validatePatient(user), HttpStatus.OK);
			} else if(user.getRole().equals("Doctor")) {
				return new ResponseEntity<User>(userService.validateDoctor(user), HttpStatus.OK);
			}	else {
				return new ResponseEntity<String>("Invalid Login", HttpStatus.NON_AUTHORITATIVE_INFORMATION);
			}
			
		}catch(RuntimeException re) {
			return new ResponseEntity<String>("Invalid Login", HttpStatus.NON_AUTHORITATIVE_INFORMATION);
		}
	}
}
