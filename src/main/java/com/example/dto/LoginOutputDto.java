package com.example.dto;

import lombok.Data;

@Data
public class LoginOutputDto {

	private String email;
	private String role;
	private boolean isLogin;
}
