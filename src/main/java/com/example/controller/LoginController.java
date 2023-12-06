package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.LoginInputDto;
import com.example.dto.LoginOutputDto;
import com.example.exception.EmployeeNotFoundException;
import com.example.exception.InvalidCredentialsException;
import com.example.service.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	LoginService loginServ;
	
	// login
	/*
	 * email, password, role - input - inputDto
	 * compare email,password & role info with db details 
	 * if details are matching return
	 *   set isLogin flag as true 
	 *   email, role, isLogin - response - outputDto
	 * else 
	 *   throw exception InvalidCredentials
	 */
	@PostMapping("/login")
	ResponseEntity<LoginOutputDto> login(@RequestBody LoginInputDto loginInputDto) throws EmployeeNotFoundException, InvalidCredentialsException {
		LoginOutputDto response = loginServ.login(loginInputDto);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	
	// logout
	/*    email - input 
	 *  set isLogin flag as false
	 *    return - email, isLogin, role - outputDto
	 * 
	 */
	@GetMapping("/logout/{email}")
	ResponseEntity<LoginOutputDto> logout(@PathVariable String email) throws EmployeeNotFoundException {
		LoginOutputDto response = loginServ.logout(email);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	// Reset
	
}
