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
import com.app.dto.InvoiceDto;
import com.app.dto.MedicineDto;
import com.app.dto.PatientDto;
import com.app.dto.PrescriptionDto;
import com.app.patientdto.PatientDetailsDto;
import com.app.pojos.Medicines;
import com.app.service.IDoctorService;

@RestController
@RequestMapping("/doctor")
@CrossOrigin
public class DoctorController {

	@Autowired
	IDoctorService doctorService;
	public DoctorController() {
		System.out.println("inside the constructor of doctor Controller");
	}
	
	
	@GetMapping("/app/{id}")
	public ResponseEntity<?> getAppointmentListOfParticlarDoctor(@PathVariable(name="id") int id) {
		System.out.println("inside getAppointmentListOfParticlarDoctor /doctor/app/{id} in admin controller --------->>");

		System.out.println("in controller appointment app getAppointmentListOfParticlarDoctor " );
		System.out.println(" getAppointmentListOfParticlarDoctor() in /admin/app------------");
		try {
			List<AppointmentDTO> l1 = doctorService.getAppointmentListByDocId(id);
			return new ResponseEntity<List<AppointmentDTO>>(l1, HttpStatus.OK);
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<String>("not added" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/app/set/{id}")
	public ResponseEntity<?> setAppointmentByAppointmentId(@PathVariable(name="id") int id) {
		System.out.println("inside setAppointmentByAppointmentId /doctor/app/set/{id} in admin controller --------->>");

		System.out.println("in controller appointment app setAppointmentByAppointmentId" );
		System.out.println(" setAppointmentByAppointmentId() in /admin/app/set------------");
		try {
			return new ResponseEntity<String>(doctorService.acceptAppointmentOfPatient(id), HttpStatus.OK);
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<String>("not added" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/patientlist/{id}")
	public ResponseEntity<?> getPatientListByDocId(@PathVariable(name="id") int id) {
		System.out.println("inside getPatientListByDocId /doctor/patientlist/{id} in doctor controller --------->>");

		System.out.println("getAllPatient() in /admin/patient");
		
		try {
			List<PatientDto> l2 =  doctorService.getPatientByDoctorId(id);
			return new ResponseEntity<List<PatientDto>>(l2, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<String>("not even a single department" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	
	@GetMapping("/patientdetails/{id}")
	public ResponseEntity<?> getPatientDetails(@PathVariable(name="id") int id) {
		
		System.out.println("inside getPatientDetails /doctor/patientdetails/{id} in doctor controller --------->>");

		System.out.println("getAllPatient() in /admin/patient");
		
		try {
			PatientDetailsDto p = doctorService.getAllDetailsOfPatient(id);
			System.out.println("---------------------------------------------------------------");
			System.out.println(p);
			return new ResponseEntity<PatientDetailsDto>(p, HttpStatus.OK);
		}catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<String>("not even a single department" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/patient/inv/{id}")
	public ResponseEntity<?> getAllInvoicesForPatient(@PathVariable(name="id") int id){
		System.out.println("inside getAllInvoicesForPatient /doctor/patient/inv/{id} in doctor controller --------->>");

		System.out.println("getAllInvoicesForPatient() in /admin/invoices/patient/id="+id+"------------");
		try {
			List<InvoiceDto> l1 = doctorService.getAllInvoicesForPatient(id);
			for (InvoiceDto invoiceDto : l1) {
				System.out.println(invoiceDto);
			}
			return new ResponseEntity<List<InvoiceDto>>(l1, HttpStatus.OK);
		}catch(RuntimeException re) {
			return new ResponseEntity<String>("not obtained " + re.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/med")
	public ResponseEntity<?> getAllMedicines(){
		System.out.println("inside getAllMedicines /doctor/med in doctor controller --------->>");

		System.out.println("in controller admin med ------>  getAllMedicines");
		try {
			List<Medicines> l1 = doctorService.getAllMedicines();
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
	
	
	@PostMapping("/presc/reg/{id}")
	ResponseEntity<String> registerPrescription(@RequestBody List<PrescriptionDto> listPres,@PathVariable(name="id") int id) {
		System.out.println("inside registerPrescription /doctor/presc/reg/{id} in doctor controller --------->>");
		System.out.println("in admin pres registerPrescription ");
		for (PrescriptionDto prescriptionDto : listPres) {
			System.out.println(prescriptionDto);
		}
		
		
		try {
			String res = doctorService.registerPrescriptionWithAppointmentId(listPres,id);
			doctorService.registerInvoicesWithPrescription(listPres, id);
			return new ResponseEntity<String>(res, HttpStatus.OK);
		}catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<String>("error " + e.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	
}
