package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IPatientDao;
import com.app.dto.AppointmentDTO;
import com.app.dto.InvoiceDto;
import com.app.patientdto.PatientDetailsDto;

@RestController
@RequestMapping("/patient")
@CrossOrigin
public class PatientController {
	
	
	@Autowired
	IPatientDao patientDao;
	
	public PatientController() {
		System.out.println("inside the constructor of patient Controller");
	}
	
	@GetMapping("/app/{id}")
	public ResponseEntity<?> getAppointmentListOfParticlarPatient(@PathVariable(name="id") int id) {
		System.out.println("in controller appointment app getAppointmentListOfParticlarPatient " );
		System.out.println(" getAppointmentListOfParticlarPatient() in /admin/app------------");
		try {
			List<AppointmentDTO> l1 = patientDao.getAppointmentListByPatientId(id);
			return new ResponseEntity<List<AppointmentDTO>>(l1, HttpStatus.OK);
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<String>("not added" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	@GetMapping("/inv/{id}")
	public ResponseEntity<String> payInvoicesFromPatient(@PathVariable(name="id") int id){
		System.out.println("inside admin/invoices/"+ id +" controller payInvoicesFromPatient--------->>");
		try {
			return new ResponseEntity<String>(patientDao.payInvoicesFromPatient(id), HttpStatus.OK);
		}catch(RuntimeException re) {
			return new ResponseEntity<String>("not success", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/inv/all/{id}")
	public ResponseEntity<String> payInvoicesFromPatientForAll(@PathVariable(name="id") int id){
		System.out.println("inside admin/invoices/"+ id +" controller payInvoicesFromPatient--------->>");
		try {
			return new ResponseEntity<String>(patientDao.payInvoicesFromPatientForAll(id), HttpStatus.OK);
		}catch(RuntimeException re) {
			return new ResponseEntity<String>("not success", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/allinv/{id}")
	public ResponseEntity<?> getAllInvoicesForPatient(@PathVariable(name="id") int id){
		System.out.println("getAllInvoicesForPatient() in /admin/invoices/patient/id="+id+"------------");
		try {
			List<InvoiceDto> l1 = patientDao.getAllInvoicesForPatient(id);
			for (InvoiceDto invoiceDto : l1) {
				System.out.println(invoiceDto);
			}
			return new ResponseEntity<List<InvoiceDto>>(l1, HttpStatus.OK);
		}catch(RuntimeException re) {
			return new ResponseEntity<String>("not obtained " + re.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/details/{id}")
	public ResponseEntity<?> getPatientDetails(@PathVariable(name="id") int id) {
		System.out.println("getAllPatient() in /admin/patient");
		
		try {
			PatientDetailsDto p = patientDao.getAllDetailsOfPatient(id);
			System.out.println("---------------------------------------------------------------");
			System.out.println(p);
			return new ResponseEntity<PatientDetailsDto>(p, HttpStatus.OK);
		}catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<String>("not even a single department" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
}
