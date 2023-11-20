package com.example.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.dao.EmployeeDao;
import com.example.entity.Address;
import com.example.entity.Employee;
import com.example.entity.Login;
import com.example.entity.Skill;

@ExtendWith(SpringExtension.class)
class EmployeeServiceMockitoTest {

	// Create EmployeeService Obj
	@InjectMocks
	EmployeeServiceImpl empService;

	@MockBean
	EmployeeDao empdao;

	// Initialization of mock objects
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	
	// CRUD 
	// Read
	@Test
	void testGetAllEmployees() {
		List<Employee> empLst = new ArrayList<>();
		
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		
		empLst.add(e1);
		empLst.add(e2);
		
		Mockito.when(empService.getAllEmployees()).thenReturn(empLst);
		
		List<Employee> empList= empService.getAllEmployees();
		
		assertEquals(2, empList.size());
	}
	
	// Add
	@Test
	void testAddEmployee() {
	Login login	= new Login("test_user2@example.com", "abc.123", "Employee", false);
	
	List<Address> addrList=new ArrayList<>();
	Address a1 = new Address();
	Address a2 = new Address();
	addrList.add(a1);
	addrList.add(a2);
	
	List<Skill> skillList = new ArrayList<>();
	Skill s1 = new Skill();
	Skill s2 = new Skill();
	
	skillList.add(s1);
	skillList.add(s2);
	
	Employee emp = new Employee(100, "test", "user2", "9999955555", login, addrList, skillList  );
	
	
	Mockito.when(empService.addEmployee(emp)).thenReturn(emp);
	// Call service method to add emp
	Employee resp	= empService.addEmployee(emp);
	
	// verify
	assertEquals(100, resp.getEmpId());
	assertEquals("test", resp.getFirstName());
	assertEquals("test_user2@example.com", resp.getLogin().getEmail());
	assertNull(resp.getAddress().get(0).getCity());
	
	
	}
	
	

}
