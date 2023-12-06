package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.LoginDao;
import com.example.dto.LoginInputDto;
import com.example.dto.LoginOutputDto;
import com.example.entity.Login;
import com.example.exception.EmployeeNotFoundException;
import com.example.exception.InvalidCredentialsException;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao loginDao;
	
	@Override
	public LoginOutputDto login(LoginInputDto loginInputDto) throws InvalidCredentialsException, EmployeeNotFoundException {
		// fetch user details from db
		Optional<Login> opt = loginDao.findById(loginInputDto.getEmail());
		
		// compare LoginInputDto(login form) details with db details
		if(opt.isPresent()) {
			// res from db
			Login login = opt.get();
			
			if(loginInputDto.getPassword().equals(login.getPassword())&&
					loginInputDto.getRole().equals(login.getRole())) {
				// if details are matching, update isLogin flag to true
				// and return LoginOutputDto
				login.setLogin(true);
				
				// save modifications in db
				Login ln = loginDao.save(login);
				
				// convert Login to LoginOutputDto and return response
				LoginOutputDto outputDto = new LoginOutputDto();
				
				outputDto.setEmail(ln.getEmail());
				outputDto.setLogin(ln.isLogin());
				outputDto.setRole(ln.getRole());
				
				return outputDto;
			} else {
				// else throw invalid credentials exception
				throw new InvalidCredentialsException("Invalid Credentials!");
			}
		}
	
		throw new EmployeeNotFoundException("Employee not found with email: "+loginInputDto.getEmail());
		
		
		
		
	}

	@Override
	public LoginOutputDto logout(String email) throws EmployeeNotFoundException {
		// Get user details from db
		Optional<Login> opt = loginDao.findById(email);
		// if user present update isLogin flag to false and return LoginOutputDto
		if(opt.isPresent()) {
			Login login = opt.get();
			
			login.setLogin(false);
			
			loginDao.save(login);
			// Convert dto to Login and return dto obj as response
			
			LoginOutputDto outputDto = new LoginOutputDto();
			outputDto.setEmail(login.getEmail());
			outputDto.setLogin(login.isLogin());
			outputDto.setRole(login.getRole());
			
			return outputDto;
			
		} else {
			// else throw EmployeeNotFoundException
			throw new EmployeeNotFoundException("Employee not found with email: "+email);
		}
		
		
	}

}
