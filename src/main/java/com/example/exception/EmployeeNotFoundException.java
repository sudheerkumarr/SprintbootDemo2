package com.example.exception;

// Step 2: Exception handling
public class EmployeeNotFoundException extends Exception {

	public EmployeeNotFoundException(String message) {
		super(message);
	}
	
}
