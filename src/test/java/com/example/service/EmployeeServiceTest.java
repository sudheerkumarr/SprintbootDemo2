package com.example.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.dto.EmployeeDto;
import com.example.dto.EmployeeRespDto;
import com.example.entity.Employee;

@SpringBootTest
class EmployeeServiceTest {

	@Autowired
	EmployeeService empService ;
	
	@Autowired
	EmployeeDto empDto;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("BeforeAll");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("AfterAll");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("BeforeEach");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("AfterEach");
	}

	// GET
	@Test
	void testGetAllEmployeesSize() {
		// get emp list from db through service method
		List<Employee> empList= empService.getAllEmployees();
		
		// get size
		int lstSize= empList.size();
		
		// validate expected value with actual value
		assertEquals(7, lstSize);
		
	}
	
	@Test
	void testGetAllEmployees() {
		// get emp list from db through service method
		List<Employee> empList= empService.getAllEmployees();
		
		// read any one record from list
		Employee emp = empList.get(4); // 102 | 9999911111 | Raj        | K         | raj_k@example.com
		
		
		// validate
		assertEquals(102, emp.getEmpId());
		assertEquals("9999911111", emp.getContactNo());
		assertEquals("Raj", emp.getFirstName());
		
	}
	
	// INSERT
	@Disabled
	@Test
	void testAddEmployeeDto() {
		// create obj
		
		// initialize empDto obj
		empDto.setFirstName("test");
		empDto.setLastName("user1");
		empDto.setContactNo("9999999999");
		empDto.setEmail("test_user1@example.com");
		empDto.setPassword("abc.123");
		
		
		// call service method to add emp to db
		EmployeeRespDto resp = empService.addEmployeeDto(empDto);
		//System.out.println(resp);// id, name....?
		// verify response
		
		assertEquals("test", resp.getFirstName());
		assertEquals("user1", resp.getLastName());
		assertEquals("99999999999", resp.getContactNo());
		
	}
	
	// Update
	
	// Delete
	
	

}
