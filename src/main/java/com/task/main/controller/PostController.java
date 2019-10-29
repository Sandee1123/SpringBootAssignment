package com.task.main.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.task.main.model.Employees;
import com.task.main.service.EmployeeService;

@RestController
public class PostController {
	
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/employees")
    private ResponseEntity<Employees> savePerson(@RequestBody Employees[] emp) {
		
		for(Employees employee : emp){
			//System.out.println(employee.getId());
			employeeService.save(employee);
			 
			}
		return new ResponseEntity<Employees>(HttpStatus.OK);
        
       
    }
	
	
	
}
