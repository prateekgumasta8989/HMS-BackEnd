package com.app.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.AppointmentDTO;
import com.app.dto.DoctorDTO;
import com.app.dto.InvoiceDto;
import com.app.pojos.AppointmentTable;
import com.app.pojos.DepartmentList;
import com.app.pojos.DocSchedule;
import com.app.pojos.Doctors;
import com.app.pojos.Invoices;
import com.app.pojos.Medicines;
import com.app.pojos.Patient;

@Repository
public class AdminDaoImple implements IAdminDao{

	@Autowired
	private SessionFactory sf;
	private Session session;
	
	
	public AdminDaoImple() {
		session = sf.getCurrentSession();
		
		System.out.println("inside admin dao implementation");
	}
	
	
	@Override
	public String addDept(DepartmentList dept) {
		session.save(dept);
		return "dept added successfully";
	}
	
	@Override
	public List<DepartmentList> getAllDepartment() {
		String jpql = "select dep from DepartmentList dep";
		List<DepartmentList> l1 = sf.getCurrentSession().createQuery(jpql, DepartmentList.class).getResultList();
		l1.size();
		return l1;
	}

	
	
	public DoctorDTO registerDoctorWithSchedule(Doctors d, DocSchedule sch,int deptId) {
		Session session = sf.getCurrentSession();
		DepartmentList dept = session.get(DepartmentList.class, deptId);
		d.setSchedule(sch);
		session.save(d);
		dept.addDoctorToDepartment(d);
		
		System.out.println(" doctor id" + d.getId());
		d.setEmail(d.getDocName() + "@" + d.getId());
		d.setPassword("hms"+d.getId()+"doctor");
		return new DoctorDTO(d.getId(), d.getDocName(), d.getDocContactInfo(), d.getDept().getDeptName(),d.getEmail(),d.getPassword()) ;	
	}

	
	@Override
	public List<Doctors> getAllDoctors() {
		String jpql = "select do from Doctors do";
		List<Doctors> l1 = sf.getCurrentSession().createQuery(jpql, Doctors.class).getResultList();
		l1.size();
		return l1;
	}


	@Override
	public String registerMedicines(Medicines medicines) {
		System.out.println("in admin dao registerMedicines " + medicines);
		sf.getCurrentSession().save(medicines);
		return "added";
	}
	
	@Override
	public List<Medicines> getAllMedicines() {
		String jpql = "select m from Medicines m";
		List<Medicines> l1 = sf.getCurrentSession().createQuery(jpql, Medicines.class).getResultList();
		for (Medicines medicines : l1) {
			System.out.println("------------------");
			System.out.println(medicines);
		}
		l1.size();
		return l1;
	}
	
	
	@Override
	public List<InvoiceDto> getAllInvoicesForAdmin() {
		String jpql = "select inv from Invoices inv";
		List<Invoices> listInvoices = sf.getCurrentSession().createQuery(jpql, Invoices.class).getResultList();
		List<InvoiceDto> listInvoicesDto = new ArrayList<>();
		if(listInvoices.size() != 0) {
			for (Invoices invoices : listInvoices) {
				listInvoicesDto.add(new InvoiceDto(invoices.getInvoiceId(), invoices.getDescription(), invoices.getStatus(), invoices.getPrice(), invoices.getPatient().getId(), invoices.getPatient().getPatientName()));
			}
		}
		return listInvoicesDto;
	}

	
	@Override
	public String acceptAppointmentOfPatient(int appId) {
		Session session = sf.getCurrentSession();
		AppointmentTable appPojo = session.get(AppointmentTable.class, appId);
		appPojo.setAppointmentStatus(1);
		Patient patient = session.get(Patient.class, appPojo.getPatient().getId());
		patient.addInvoiceToPatient(new Invoices("appointment charge", "unpaid", 250));
		return "updated";
	}

	
	@Override
	public List<AppointmentDTO> getAllAppointmentList() {
		Session session = sf.getCurrentSession();
		String jpql = "select app from AppointmentTable app";
		List<AppointmentTable> list = session.createQuery(jpql, AppointmentTable.class).getResultList();
		List<AppointmentDTO> listDto = new ArrayList<>();
		for (AppointmentTable app : list) {
			app.getPatient().getId();
			app.getDoctor().getId();
			
			listDto.add(new AppointmentDTO(app.getId(), app.getProblem(), app.getAppointmentDate(), app.getPatient().getPatientName(), app.getPatient().getPatientGender(), app.getPatient().getPatientBloodGroup()
					, app.getPatient().getPatientContactInfo(), 0, app.getDoctor().getId(), app.getPatient().getPatientCaseStatus(), app.getAppointmentStatus(), app.getDoctor().getDocName(), app.getDoctor().getDept().getDeptName()));
		}
		return listDto;
	}

}
