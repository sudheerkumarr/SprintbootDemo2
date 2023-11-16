package com.example.service;

import java.util.List;
import java.util.Optional;

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

	@Override
	public Employee addEmployee(Employee emp) {
		// Call dao/repository method to add employee in db
		Employee e = empDao.save(emp);

		// return response
		return e;
	}

	@Override
	public Employee getEmployeeById(int id) {
		// call dao/repository method to get employee by id
		Optional<Employee> opt = empDao.findById(id);

		// return emp obj if present else return null
		if (opt.isPresent()) {
			return opt.get();
		}

		return null;
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		// call dao/repository method to get employee by id
		Optional<Employee> opt = empDao.findById(emp.getEmpId());

		// return emp obj if present else return null
		if (opt.isPresent()) {
			Employee e = empDao.save(emp);

			return e;
		}

		return null;
	}

	@Override
	public void deleteEmployeeById(int id) {
		// call dao delete method to remove employee from db
		Optional<Employee> opt = empDao.findById(id);

		// delete emp from db, if present else return null
		if (opt.isPresent()) {
			empDao.deleteById(id);

		}

	}

	@Override
	public Employee updateContactNo(int id, String newContactNo) {
		// call dao delete method to remove employee from db
		Optional<Employee> opt = empDao.findById(id);

		// update emp contactNo if present else return null
		if (opt.isPresent()) {
			// get employee from optional using get()
			Employee emp = opt.get();
			
			// update contact no.
			emp.setContactNo(newContactNo);
			
			// save updated emp in the db.
			Employee e = empDao.save(emp);
			
			// return updated employee
			return e;

		}
		
		return null;
	}

	@Override
	public Employee getEmployeeByFirstName(String firstName) {
		// call employee dao method to find employee using firstName
		Employee emp = empDao.findByFirstName(firstName);
		
		// return response
		return emp;
	}

	@Override
	public Employee getEmployeeByContactNo(String contactNo) {
		// Call employee dao method to find employee based on contact no
		Employee emp = empDao.findByContactNo(contactNo);
		// return response
		return emp;
	}

	@Override
	public Employee getEmployeeByLastName(String lastName) {
		// call dao to find emp based on lastname
		Employee emp = empDao.getEmployeeByLastName(lastName);
		// return response
		return emp;
	}

}
