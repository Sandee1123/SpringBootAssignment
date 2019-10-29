package com.task.main.service;



import java.util.List;

import com.task.main.model.Employees;


public interface EmployeeService {

	 void save(Employees emp);

	 List<Employees> getEmployeesBydeptNo(int deptNo);

	 List<Employees> getByName(String name);

}

