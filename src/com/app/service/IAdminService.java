package com.app.service;

import java.util.List;

import com.app.dto.AppointmentDTO;
import com.app.dto.DoctorDTO;
import com.app.dto.InvoiceDto;
import com.app.pojos.DepartmentList;
import com.app.pojos.DocSchedule;
import com.app.pojos.Doctors;
import com.app.pojos.Medicines;

public interface IAdminService {
	String addDept(DepartmentList dept);
	DoctorDTO registerDoctorWithSchedule(Doctors d, DocSchedule sch,int deptId);
	List<DepartmentList> getAllDepartment();
	List<Doctors> getAllDoctors();
	String registerMedicines(Medicines medicines);
	List<Medicines> getAllMedicines();
	List<InvoiceDto> getAllInvoicesForAdmin();
	String acceptAppointmentOfPatient(int appId);
	List<AppointmentDTO> getAllAppointmentList();
	
}
