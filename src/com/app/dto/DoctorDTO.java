package com.app.dto;

public class DoctorDTO {
	Integer id;
	String docName;
	String docContactInfo;
	String docDept;
	String email;
	String password;
	
	public DoctorDTO(Integer id, String docName, String docContactInfo, String docDept, String email, String password) {
		super();
		this.id = id;
		this.docName = docName;
		this.docContactInfo = docContactInfo;
		this.docDept = docDept;
		this.email = email;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public DoctorDTO() {
		// TODO Auto-generated constructor stub
	}
	public DoctorDTO(Integer id, String docName, String docContactInfo, String docDept) {
		super();
		this.id = id;
		this.docName = docName;
		this.docContactInfo = docContactInfo;
		this.docDept = docDept;
	}

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public String getDocContactInfo() {
		return docContactInfo;
	}
	public void setDocContactInfo(String docContactInfo) {
		this.docContactInfo = docContactInfo;
	}
	public String getDocDept() {
		return docDept;
	}
	public void setDocDept(String docDept) {
		this.docDept = docDept;
	}
	@Override
	public String toString() {
		return "DoctorDTO [id=" + id + ", docName=" + docName + ", docContactInfo=" + docContactInfo + "]";
	}
	
	
	
}
