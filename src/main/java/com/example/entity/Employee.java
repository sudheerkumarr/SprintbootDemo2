package com.example.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@ToString
public class Employee {

	@Id
	@GeneratedValue

	private int empId;

	// Step 2 - Input field validations
	@NotBlank
	@Size(min = 3, message = "firstName length should be greater than or equal 3 char")
	private String firstName;

	private String lastName;
	// @Setter
	// @Getter
	@NotBlank
	@Size(min = 10, max = 10, message = "Number of digits to be 10")
	private String contactNo;

	// OneToOne relationship
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_login_fk")
	private Login login;

	// OneToMany - Unidirectional
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_addr_fk")
	private List<Address> address;

	// ManaToMany -Unidirectional
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinTable(name = "employee_skills", joinColumns = { @JoinColumn(name = "emp_id") }, inverseJoinColumns = {
			@JoinColumn(name = "skill_id") })
	private List<Skill> skillList;

}