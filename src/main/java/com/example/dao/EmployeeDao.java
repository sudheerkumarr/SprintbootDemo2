package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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
	
	
	
	
}
