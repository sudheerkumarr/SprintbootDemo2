package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.EmployeeDao;
import com.example.dao.LoginDao;
import com.example.dao.SkillDao;
import com.example.dto.EmployeeDto;
import com.example.dto.EmployeeRespDto;
import com.example.entity.Address;
import com.example.entity.Employee;
import com.example.entity.Login;
import com.example.entity.Skill;
import com.example.exception.EmployeeNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao empDao;
	
	@Autowired
	LoginDao loginDao;
	
	@Autowired
	SkillDao skillDao;

	@Override
	public List<Employee> getAllEmployees() {
		// Get all employee from db
		List<Employee> lst = empDao.findAll();

		return lst;
	}

	public List<EmployeeRespDto> getAllEmps() {
		// create list with EmployeeRespDto type
		// for - read one employee at a time
		// convert emp to empRespDto type
		// add empRespDto to empRespDtoList
		// return empRespDtoList
		return null;
	}


	
	@Override
	public Employee addEmployee(Employee emp) {
		// Call dao/repository method to add employee in db
		Employee e = empDao.save(emp);

		// return response
		return e;
	}

	// Step 3: throw Employee not found exception, if employee not found
	@Override
	public Employee getEmployeeById(int id) throws EmployeeNotFoundException {
		// call dao/repository method to get employee by id
		Optional<Employee> opt = empDao.findById(id);

		// return emp obj if present else return null
		if (opt.isPresent()) {
			return opt.get();
		}

		throw new EmployeeNotFoundException("Employee not found with id: " + id);
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

	@Override
	public EmployeeRespDto addEmployeeDto(EmployeeDto empDto) {
		// Converting EmployeeDto to Employee obj
		System.out.println("EmpDto: " + empDto);
		// Create employee object
		Employee emp = new Employee();
		System.out.println("Emp: " + emp);

		// read details from dto object and update emp object
		emp.setFirstName(empDto.getFirstName());
		emp.setLastName(empDto.getLastName());
		emp.setContactNo(empDto.getContactNo());

		// Create Login obj
		Login login = new Login();
		System.out.println("Login: " + login);

		login.setEmail(empDto.getEmail());
		login.setPassword(empDto.getPassword());
		login.setRole("Employee");
		login.setLogin(false);

		emp.setLogin(login);

		System.out.println("Emp: " + emp);

		// Call dao method to store emp in db
		Employee newEmp = empDao.save(emp);

		// Convert Employee to EmployeeRespDto

		// Create EmployeeResponseDto object
		EmployeeRespDto empRespDto = new EmployeeRespDto();

		// update responseDto details with emp details received from db

		empRespDto.setFirstName(newEmp.getFirstName());
		empRespDto.setLastName(newEmp.getLastName());
		empRespDto.setEmail(newEmp.getLogin().getEmail());
		empRespDto.setContactNo(newEmp.getContactNo());

		return empRespDto;
	}

	@Override
	public Employee updateEmployeeDto(EmployeeDto empDto) {
		// Convert EmployeeDto to Employee
		Employee emp = new Employee();
		emp.setEmpId(empDto.getEmpId());
		emp.setFirstName(empDto.getFirstName());
		emp.setLastName(empDto.getLastName());
		emp.setContactNo(empDto.getContactNo());
		
		Login login = new Login();
		login.setEmail(empDto.getEmail());
		login.setPassword(empDto.getPassword());
		
		emp.setLogin(login);
		
		// save emp obj in db
		Employee updatedEmp = empDao.save(emp);
		
		// return response
		return updatedEmp;
	}

	// Find email based on firstName
	@Override
	public String findEmailByEmpName(String firstName) {
		String email = empDao.findEmailByfirstName(firstName);
		return email;
	}

	@Override
	public Employee addEmpAddr(int empId, Address address) throws EmployeeNotFoundException {
		// find emp based on id;
		Optional<Employee> opt= empDao.findById(empId);
		
		if(opt.isPresent()) {
			// fetch existing address details
			
			Employee emp = opt.get();
			
			// add new address to emp address list
			List<Address> addrList = emp.getAddress(); // 1
			addrList.add(address); // 1, 2
			
			emp.setAddress(addrList);
			
			// save emp in db and return employee
			return empDao.save(emp);
			
			
		} else {
			throw new EmployeeNotFoundException("Employee not found with id: "+ empId);
		}
		
		
	}

	@Override
	public Employee addEmpSkill(int empId, int skillId) {
		// fetch emp details using empId
	    Employee emp  =	empDao.findById(empId).get();
		
	    // fetch skill details using skillId
		Skill skill = skillDao.findById(skillId).get();
		
		// add skill to emp
		List<Skill> skillList = emp.getSkillList(); // 2 skill
		skillList.add(skill); // 3 skill
		
		emp.setSkillList(skillList);
		
		// save emp to db & return upated emp
		return empDao.save(emp);
		
	
	}

}
