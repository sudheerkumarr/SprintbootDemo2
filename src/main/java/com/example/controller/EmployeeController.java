package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.EmployeeDto;
import com.example.dto.EmployeeRespDto;
import com.example.entity.Address;
import com.example.entity.Employee;
import com.example.exception.EmployeeNotFoundException;
import com.example.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class EmployeeController {

	@Autowired
	EmployeeService empService;

	// Get all employee details
	@GetMapping("/employee/all")
	ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> empList = empService.getAllEmployees();
		return new ResponseEntity<>(empList, HttpStatus.OK); // 200 OK
	}

	// Get employee by id
	@GetMapping("/employee/findById/{id}")
	ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id) throws EmployeeNotFoundException {
		// Call service method to get emp based on id
		Employee emp = empService.getEmployeeById(id);

		// return emp
		return new ResponseEntity<>(emp, HttpStatus.OK); // 200 OK
	}

	// Get employee by name
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

	// Step3 - Add @Valid to method input- Input Field Validation
	// insert employee in the db
	@PostMapping("/employee/add")
	Employee addEmployee(@Valid @RequestBody Employee emp) {
		// Call service add method to add emp in db
		Employee newEmp = empService.addEmployee(emp);

		// return response
		return newEmp;
	}

	// insert employee in the db
	@PostMapping("/employee/add/dto")
	EmployeeRespDto addEmployeeDto(@RequestBody EmployeeDto empDto) {
		// Call service add method to add emp in db
		EmployeeRespDto resDto = empService.addEmployeeDto(empDto);

		// return response
		return resDto;
	}

	// update employee
	@PutMapping("/employee/update")
	Employee updateEmployee(@RequestBody Employee emp) {
		// Call service method to update emp in db
		Employee e = empService.updateEmployee(emp);

		// return response
		return e;

	}
	
	// update employee
		@PutMapping("/employee/update/dto")
		Employee updateEmployee(@RequestBody EmployeeDto empDto) {
			// Call service method to update emp in db
			Employee e = empService.updateEmployeeDto(empDto);

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

	@GetMapping("/employee/findEmailBy/{firstName}")
	String findEmailByEmpName(@PathVariable String firstName) {
		String email = empService.findEmailByEmpName(firstName);
		return email;
	}
	
	// add employee address
	@PostMapping("/employee/{empId}/add/address")
	Employee addEmpAddr(@PathVariable int empId, @RequestBody Address address) throws EmployeeNotFoundException {
		return empService.addEmpAddr(empId, address);
	}
	
	// map/add employee skills
	@GetMapping("/employee/map/{empId}/skill/{skillId}")
	Employee addEmpSkill(@PathVariable int empId, @PathVariable int skillId) {
		return empService.addEmpSkill(empId, skillId);
	}
}
