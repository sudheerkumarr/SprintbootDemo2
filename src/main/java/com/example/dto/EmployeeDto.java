package com.example.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class EmployeeDto {
	private int empId;
	private String firstName;
	private String lastName;
	private String email;
	private String contactNo;
	private String password;
}
