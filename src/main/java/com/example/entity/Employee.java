package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
//@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
//@Setter
@ToString
public class Employee {
	
	@Id
	@GeneratedValue
	private int empId;
	
	private String firstName;
	private String lastName;
	//@Setter
	//@Getter
	private String contactNo;

}
