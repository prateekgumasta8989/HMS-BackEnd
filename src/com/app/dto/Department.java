package com.app.dto;

public class Department {
	int deptId;
	String deptName;
	
	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(int id, String name) {
		this.deptId = id;
		this.deptName = name;
	}
	
	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + "]";
	}
		
}
