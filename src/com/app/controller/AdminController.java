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
import com.app.dto.DoctorWhole;
import com.app.dto.InvoiceDto;
import com.app.dto.MedicineDto;
import com.app.pojos.DepartmentList;
import com.app.pojos.DocSchedule;
import com.app.pojos.Doctors;
import com.app.pojos.Medicines;
import com.app.service.IAdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {
	
	
	@Autowired
	IAdminService adminService;
	
	
	public AdminController() {
		System.out.println("in admin controller");
	}
	
	@PostMapping("/dept/reg")
	public ResponseEntity<String> registerDept(@RequestBody DepartmentList dept){
		System.out.println("inside registerDept /admin/dept/reg in admin controller --------->>");
		try {
			return new ResponseEntity<String>(adminService.addDept(dept), HttpStatus.OK);	
		}catch(RuntimeException re) {
			return new ResponseEntity<String>("DEPT not added successfully", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PostMapping("/doctor/reg/{id}")
	public ResponseEntity<?> addDoctor(@RequestBody DoctorWhole dCom,@PathVariable(name="id") int id){
		System.out.println("inside addDoctor /admin/doctor/reg/{id} in admin controller --------->>");

		System.out.println("inside add doctor in controller --------->>" + dCom);
		Doctors doc = new Doctors(null, dCom.getDocName(), dCom.getDocContactInfo());
		DocSchedule sch = new DocSchedule(dCom.getDaysInWeek(), dCom.getAvailableTime(), dCom.getPerPatientTime(), dCom.getDocStatus());
		
		System.out.println("obj1 = " + doc);
		System.out.println("obj2 = " + sch);
		try {
			return new ResponseEntity<DoctorDTO>(adminService.registerDoctorWithSchedule(doc, sch, id), HttpStatus.OK);
		}catch(RuntimeException re) {
			return new ResponseEntity<String>("not added successfully", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@GetMapping("/dept")
	public ResponseEntity<?> getAllDeptList(){
		System.out.println("inside getAllDeptList /admin/dept in admin controller --------->>");

		System.out.println(" getAllDeptList() in /admin/dept");
		List<DepartmentList> l1 = adminService.getAllDepartment();
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
	
	
	@GetMapping("/doctor")
	public ResponseEntity<?> allDoctor(){	
		System.out.println("inside allDoctor /admin/doctor in admin controller --------->>");

		System.out.println("getAllDoctor() in /admin/doc------------");
		List<Doctors> l1Doc = adminService.getAllDoctors();
		List<DoctorDTO> l2DcoDto = new ArrayList<>();
		if(l1Doc.size() != 0)
		{
			for (Doctors d : l1Doc) {
				l2DcoDto.add(new DoctorDTO(d.getId(), d.getDocName(), d.getDocContactInfo(),d.getDept().getDeptName(),d.getEmail(),""));
			}
			return new ResponseEntity<List<DoctorDTO>>(l2DcoDto, HttpStatus.OK);
		}
		return new ResponseEntity<String>("not even a single doctor", HttpStatus.OK);
	}
	
	
	@PostMapping("/med/reg")
	public ResponseEntity<String> registerMedicine(@RequestBody MedicineDto medDto){
		System.out.println("inside registerMedicine /admin/med/reg in admin controller --------->>");
		System.out.println("in controller admin med ------>  registerMedicine " + medDto);
		try {
			Medicines med = new Medicines(medDto.getMedName(), medDto.getMedCategory(), medDto.getMedPrice());
			return new ResponseEntity<String>(adminService.registerMedicines(med), HttpStatus.OK);
		}catch (RuntimeException e) {
			return new ResponseEntity<String>("medicine does not added", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@GetMapping("/med")
	public ResponseEntity<?> getAllMedicines(){
		System.out.println("inside getAllMedicines /admin/med in admin controller --------->>");

		System.out.println("in controller admin med ------>  getAllMedicines");
		try {
			List<Medicines> l1 = adminService.getAllMedicines();
			List<MedicineDto> l2 = new ArrayList<MedicineDto>();
			if(l1.size()!=0) {
				for (Medicines med : l1) {
					l2.add(new MedicineDto(med.getMedID(), med.getMedName(), med.getMedCategory(), med.getMedPrice()));
				}
			}
			return new ResponseEntity<List<MedicineDto>>(l2, HttpStatus.OK);
		}catch(RuntimeException re) {
			return new ResponseEntity<String>("not obtained", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/showinv")
	public ResponseEntity<?> getAllInvoicesForAdmin(){
		System.out.println("inside getAllInvoicesForAdmin /admin/showinv in admin controller --------->>");

		System.out.println("getAllInvoicesForAdmin() in /admin/invoices/showinv------------");
		try {
			return new ResponseEntity<List<InvoiceDto>>(adminService.getAllInvoicesForAdmin(), HttpStatus.OK);
		}catch(RuntimeException re) {
			return new ResponseEntity<String>("not obtained", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/setapp/{id}")
	public ResponseEntity<?> setAppointmentByAppointmentId(@PathVariable(name="id") int id) {
		System.out.println("inside setAppointmentByAppointmentId /admin/setapp/{id} in admin controller --------->>");

		System.out.println("in controller appointment app setAppointmentByAppointmentId" );
		System.out.println(" setAppointmentByAppointmentId() in /admin/app/set------------");
		try {
			return new ResponseEntity<String>(adminService.acceptAppointmentOfPatient(id), HttpStatus.OK);
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<String>("not added" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/app/all")
	public ResponseEntity<?> getAllAppointments() {
		System.out.println("inside getAllAppointments /admin/app/all in admin controller --------->>");
		System.out.println("in controller appointment app getAllAppointments" );
		System.out.println(" getAllAppointments() in /admin/app/all------------");
		try {
			List<AppointmentDTO> l1 = adminService.getAllAppointmentList();
			return new ResponseEntity<List<AppointmentDTO>>(l1, HttpStatus.OK);
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<String>("not added" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
