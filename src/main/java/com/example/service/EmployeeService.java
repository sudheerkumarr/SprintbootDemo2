package com.example.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.dto.EmployeeDto;
import com.example.dto.EmployeeRespDto;
import com.example.entity.Employee;
import com.example.exception.EmployeeNotFoundException;

public interface EmployeeService {
	
	List<Employee> getAllEmployees();
	Employee addEmployee(Employee emp);
	EmployeeRespDto addEmployeeDto(EmployeeDto empDto);
	Employee getEmployeeById(int id) throws EmployeeNotFoundException;
	Employee updateEmployee(Employee emp);
	Employee updateEmployeeDto(EmployeeDto empDto);
	void deleteEmployeeById(int id);
	Employee updateContactNo(int id, String newContactNo);
	Employee getEmployeeByFirstName(String firstName);
	Employee getEmployeeByContactNo(@PathVariable("cNo") String contactNo);
	Employee getEmployeeByLastName(@RequestBody String lastName);
	
}
