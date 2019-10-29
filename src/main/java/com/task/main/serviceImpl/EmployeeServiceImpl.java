package com.task.main.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.main.model.Employees;
import com.task.main.repository.EmployeesRepository;
import com.task.main.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeesRepository employeesRepository;

	public void save(Employees emp) {
		employeesRepository.save(emp);
	}

	public List<Employees> getByName(String name) {

		List<Employees> list = employeesRepository.findByName(name);
		return list;
	}

	public List<Employees> getEmployeesBydeptNo(int deptNo) {

		List<Employees> list = employeesRepository.findByDeptNo(deptNo);
		return list;
	}

}
