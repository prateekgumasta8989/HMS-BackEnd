package com.app.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IAdminDao;
import com.app.dto.AppointmentDTO;
import com.app.dto.DoctorDTO;
import com.app.dto.InvoiceDto;
import com.app.pojos.DepartmentList;
import com.app.pojos.DocSchedule;
import com.app.pojos.Doctors;

import com.app.pojos.Medicines;

@Service
@Transactional
public class AdminServiceImple implements IAdminService{

	@Autowired
	private IAdminDao dao;
	
	public AdminServiceImple() {
		System.out.println("inside admin service implementation");
	}
	
	
	@Override
	public String addDept(DepartmentList dept) {
		return dao.addDept(dept);
	}
	
	@Override
	public List<DepartmentList> getAllDepartment() {
		return dao.getAllDepartment();
	}

	
	
	public DoctorDTO registerDoctorWithSchedule(Doctors d, DocSchedule sch,int deptId) {
		return dao.registerDoctorWithSchedule(d, sch, deptId);
	}

	
	@Override
	public List<Doctors> getAllDoctors() {
		return dao.getAllDoctors();
	}


	@Override
	public String registerMedicines(Medicines medicines) {
		return dao.registerMedicines(medicines);
	}
	
	@Override
	public List<Medicines> getAllMedicines() {
		return dao.getAllMedicines();
	}
	
	
	@Override
	public List<InvoiceDto> getAllInvoicesForAdmin() {
		return dao.getAllInvoicesForAdmin();
	}

	
	@Override
	public String acceptAppointmentOfPatient(int appId) {
		return dao.acceptAppointmentOfPatient(appId);
	}

	
	@Override
	public List<AppointmentDTO> getAllAppointmentList() {
		return dao.getAllAppointmentList();
	}

}
