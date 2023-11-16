package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	@GetMapping("/employee/findById/{id}")
	Employee getEmployeeById(@PathVariable("id") int id) {
		// Call service method to get emp based on id
		Employee emp = empService.getEmployeeById(id);
		
		// return emp
		return emp;
	}
	
	//Get employee by name
	@GetMapping("/employee/byFirstName/{firstName}")
	Employee getEmployeeByFirstName(@PathVariable("firstName") String firstName) {
		// Call service method to find employee by firstName
		Employee emp = empService.getEmployeeByFirstName(firstName);
		
		// return response
		return emp;
	}
	
	// search emp by contact no
	@GetMapping("/employee/byContactNo/{cNo}")
	Employee getEmployeeByContactNo(@PathVariable("cNo") String contactNo) {
		// Call service method to get emp based on contact no
		Employee emp = empService.getEmployeeByContactNo(contactNo);
		
		// return response
		return emp;
	}
	
	
	// Search employee based on last name
	
	@PostMapping("/employee/byLastName")
	Employee getEmployeeByLastName(@RequestBody String lastName) {
		System.out.println(lastName);
		// call service method to find employee based last name
		Employee emp = empService.getEmployeeByLastName(lastName);
		// return response
		return emp;
	}
	
	// insert employee in the db
	@PostMapping("/employee/add")
	Employee addEmployee(@RequestBody Employee emp) {
		// Call service add method to add emp in db
		Employee newEmp = empService.addEmployee(emp);
		
		// return response
		return newEmp;
	}
	
	
	
	// update employee 
	@PutMapping("/employee/update")
	Employee updateEmployee(@RequestBody Employee emp) {
		// Call service method to update emp in db
		Employee e = empService.updateEmployee(emp);
		
		// return response
		return e;
		
	}
	
	// delete employee
	@DeleteMapping("/employee/delete/{id}")
	void deleteEmployeeById(@PathVariable int id) {
		// Call service method to delete employee using id
		empService.deleteEmployeeById(id);
		
	}
	
	// patch - updating specific parameter
	@PatchMapping("/employee/update/empId/{id}/contactNo/{cNo}")
	Employee updateContactNo(@PathVariable int id, @PathVariable("cNo") String newContactNo) {
		// Call service method to update contact no.
		Employee e = empService.updateContactNo(id, newContactNo);
		
		// return response
		return e;
	}
	
}
