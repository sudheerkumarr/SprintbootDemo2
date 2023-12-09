package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Address {
	// Fields
	@Id
	@GeneratedValue
	private int addrId;

	private String city;
	private String state;
	
	

}
