package com.example.service;

import java.util.List;

import com.example.entity.Employee;

public interface EmployeeService {
	
	List<Employee> getAllEmployees();
	Employee addEmployee(Employee emp);
	Employee getEmployeeById(int id);
	Employee updateEmployee(Employee emp);
	void deleteEmployeeById(int id);
	Employee updateContactNo(int id, String newContactNo);

}
