package com.example.entity;

import java.time.LocalDateTime;

import lombok.Data;

// Step1 - Exception handling
@Data
public class ErrorResponse {
	
	// status codes - 1xx, 2xx...
	private int status; 
	String message;
	LocalDateTime timeStamp;

}
