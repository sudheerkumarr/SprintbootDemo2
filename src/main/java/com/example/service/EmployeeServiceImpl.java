package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.EmployeeDao;
import com.example.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao empDao;
	
	@Override
	public List<Employee> getAllEmployees() {
		// Get all employee from db
		List<Employee> lst = empDao.findAll();
		return lst;
	}

}
