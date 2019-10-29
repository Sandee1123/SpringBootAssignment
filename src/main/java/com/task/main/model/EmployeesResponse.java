package com.task.main.model;

import java.util.List;

public class EmployeesResponse {
	List<Employees> emp;
	Errorcodes info;
	
	public List<Employees> getEmp() {
		return emp;
	}
	public void setEmp(List<Employees> emp) {
		this.emp = emp;
	}
	public Errorcodes getInfo() {
		return info;
	}
	public void setInfo(Errorcodes info) {
		this.info = info;
	}
	
	
	
	
	

}
