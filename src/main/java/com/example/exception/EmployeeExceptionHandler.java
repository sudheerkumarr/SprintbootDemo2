package com.example.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.entity.ErrorResponse;

// Step 4 - create ErrorResponse object and return as a response in case employee not found
@ControllerAdvice
public class EmployeeExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(EmployeeNotFoundException exception) {
		// Create Error response Obj
		ErrorResponse error = new ErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value()); // 404 not found
		error.setMessage(exception.getMessage()); //get message from exception
		error.setTimeStamp(LocalDateTime.now()); // system time
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);  //404 Not found
	}
}
