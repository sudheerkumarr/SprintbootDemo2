package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.service.EmployeeService;


@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	// Get all employee details
	@GetMapping("/employee/all")
	List<Employee> getAllEmployees() {
		return empService.getAllEmployees();
	}
	
	// Get employee by id
	
	
	// insert employee in the db
	
	
	// update employee 
	
	
	// delete employee

}
