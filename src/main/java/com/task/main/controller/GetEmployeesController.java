package com.task.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.task.main.model.Employees;
import com.task.main.model.EmployeesResponse;
import com.task.main.model.Errorcodes;
import com.task.main.service.EmployeeService;

@RestController
public class GetEmployeesController {
	
	@Autowired(required=true)
	private EmployeeService employeeService;

	@GetMapping("/employees/depts/{deptNo}")
	private ResponseEntity<EmployeesResponse> getEmployyes(@PathVariable("deptNo") int deptNo) {
		List<Employees> emp = employeeService.getEmployeesBydeptNo(deptNo);
		if (null != emp) {

			Errorcodes info = new Errorcodes();
			info.setErrorCode(1);
			info.setErrorMessage(" data available ");

			EmployeesResponse data = new EmployeesResponse();
			
			data.setEmp(emp);
			data.setInfo(info);

			return new ResponseEntity<EmployeesResponse>(data, HttpStatus.OK);
		} else {
			Errorcodes info = new Errorcodes();
			info.setErrorCode(0);
			info.setErrorMessage("No data available ");

			EmployeesResponse data = new EmployeesResponse();
			data.setInfo(info);

			return new ResponseEntity<EmployeesResponse>(data, HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping("/employees/{name}")
	private ResponseEntity<EmployeesResponse> getByName(@PathVariable("name") String name) {
		List<Employees> emp = employeeService.getByName(name);
		if (null != emp) {

			Errorcodes info = new Errorcodes();
			info.setErrorCode(1);
			info.setErrorMessage(" data available ");

			EmployeesResponse data = new EmployeesResponse();
			
				data.setEmp(emp);
			data.setInfo(info);

			return new ResponseEntity<EmployeesResponse>(data, HttpStatus.OK);
		} else {
			Errorcodes info = new Errorcodes();
			info.setErrorCode(0);
			info.setErrorMessage("No data available ");

			EmployeesResponse data = new EmployeesResponse();
			data.setInfo(info);

			return new ResponseEntity<EmployeesResponse>(data, HttpStatus.BAD_REQUEST);

		}
	}
}
