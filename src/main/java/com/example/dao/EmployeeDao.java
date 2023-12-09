package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.entity.Address;
import com.example.entity.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {
	
	Employee findByFirstName(String firstName);
	Employee findByContactNo(String contactNo);
	
	// Native Query
	//@Query(value="select * from employee where last_name=:lName", nativeQuery=true)
	//Employee getEmployeeByLastName(@Param("lName") String lastName);
	
	
	// JPQL Query
	@Query("select e from Employee e where e.lastName=:lName")
	Employee getEmployeeByLastName(@Param("lName") String lastName);
	
	@Query(value="select email from login join employee on employee.emp_login_fk=login.email where employee.first_name=:fName", nativeQuery=true)
	String findEmailByfirstName(@Param("fName") String firstName);
	
	
	
	
	
}
