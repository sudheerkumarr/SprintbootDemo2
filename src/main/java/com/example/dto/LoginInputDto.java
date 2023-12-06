package com.example.dto;

import lombok.Data;

@Data
public class LoginInputDto {
	private String email;
	private String password;
	private String role;
}
