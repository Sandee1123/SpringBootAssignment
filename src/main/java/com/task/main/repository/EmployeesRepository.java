package com.task.main.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.task.main.model.Employees;

@Repository
public interface EmployeesRepository extends CrudRepository<Employees, Integer> {
	
	
	List<Employees> findByDeptNo(Integer deptNo);
	
	 @Query("SELECT t FROM Employees t WHERE t.firstName =:firstName or t.lastName=:firstName")
	    public List<Employees> findByName(String firstName);

	
	
}
