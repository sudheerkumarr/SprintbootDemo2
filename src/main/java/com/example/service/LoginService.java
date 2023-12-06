package com.example.service;

import com.example.dto.LoginInputDto;
import com.example.dto.LoginOutputDto;
import com.example.exception.EmployeeNotFoundException;
import com.example.exception.InvalidCredentialsException;

public interface LoginService {
	LoginOutputDto login(LoginInputDto loginInputDto) throws InvalidCredentialsException, EmployeeNotFoundException;
	LoginOutputDto logout(String email) throws EmployeeNotFoundException;

}
