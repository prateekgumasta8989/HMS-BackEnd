package com.app.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
public class UserDaoImple implements IUserDao{

	

	@Autowired
	private SessionFactory sf;

	public UserDaoImple() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<DepartmentList> getAllDepartment() {
		String jpql = "select dep from DepartmentList dep";
		List<DepartmentList> l1 = sf.getCurrentSession().createQuery(jpql, DepartmentList.class).getResultList();
		l1.size();
		return l1;
	}
	@Override
	public List<Doctors> getDoctorDeptWise(int id) {
		Session session = sf.getCurrentSession();
		DepartmentList dept = session.get(DepartmentList.class, id);
		 List<Doctors> l1 =  dept.getDoctors();l1.size();
		 return l1;
	}

	
	@Override
	public PatientDto registerAppointmentNew(AppointmentDTO appDto) {
		Session session = sf.getCurrentSession();
		Patient patient= new Patient(appDto.getPatientName(), appDto.getPatientGender(), appDto.getPatientBloodGroup(), appDto.getPatientContactInfo());
		
		session.save(patient);
		
		System.out.println("in admin dao app date  =>>>" + appDto.getAppointmentDate());
		AppointmentTable appTable = new AppointmentTable(appDto.getProblem(), appDto.getAppointmentDate(), 0);
		
		session.save(appTable);
		
		Doctors doc = session.get(Doctors.class, appDto.getDocId());
		doc.addAppointmentToDoctor(appTable);
		appTable.setPatient(patient);
		System.out.println("your patient iid" + patient.getId());
		patient.setEmail(patient.getPatientName() + "@" + patient.getId());
		patient.setPassword("hms" + patient.getId() + "patient");
		return new PatientDto(patient.getId(), patient.getPatientName(), patient.getPatientGender(), patient.getPatientBloodGroup(), patient.getPatientContactInfo(), patient.getPatientCaseStatus(), patient.getEmail(), patient.getPassword()); 
	}
	
	
	
	@Override
	public List<PatientDto> getAllPatient() {
		String jpql = "select p from Patient p";
		List<Patient> l1 = sf.getCurrentSession().createQuery(jpql, Patient.class).getResultList();
		List<PatientDto> l2 = new ArrayList<>();
		if(l1.size() != 0) {
			
				for (Patient p: l1) {
					l2.add(new PatientDto(p.getId(), p.getPatientName(), p.getPatientGender(), p.getPatientBloodGroup(), p.getPatientContactInfo(), p.getPatientCaseStatus(),p.getEmail(),p.getPassword()));
				}
		
		}
		return l2;
	}
	@Override
	public User validateAdmin(User u) {
		String jpql = "select ad from Admin ad where ad.email=:em and ad.password=:pwd";
		Admin ad =  sf.getCurrentSession().createQuery(jpql, Admin.class).setParameter("em", u.getEmail()).setParameter("pwd", u.getPassword()).getSingleResult();
		User u1 = new User(ad.getId(), ad.getEmail(), ad.getPassword(), "Admin");
		return u1;
	}


	@Override
	public User validatePatient(User u) {
		String jpql = "select p from Patient p where p.email=:em and p.password=:pwd";
		Patient ad =  sf.getCurrentSession().createQuery(jpql, Patient.class).setParameter("em", u.getEmail()).setParameter("pwd", u.getPassword()).getSingleResult();
		User u1 = new User(ad.getId(), ad.getEmail(), ad.getPassword(), "Admin");
		return u1;
	}


	@Override
	public User validateDoctor(User u) {
		String jpql = "select d from Doctors d where d.email=:em and d.password=:pwd";
		Doctors ad =  sf.getCurrentSession().createQuery(jpql, Doctors.class).setParameter("em", u.getEmail()).setParameter("pwd", u.getPassword()).getSingleResult();
		User u1 = new User(ad.getId(), ad.getEmail(), ad.getPassword(), "Admin");
		return u1;
	}

}
