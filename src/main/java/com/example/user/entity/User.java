package com.example.user.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;
	@NotBlank(message = "firstname may not be null")
	private String firstName;
	@NotBlank(message = "lastname may not be null")
	private String lastName;
	@Email(message = "please enter correct email id")
	private String email;
	
	@Size(min=0,max=10)
	@Pattern(regexp="(^$|[0-9]{10})")
	private String mobileNumber;
	
	private Long departmentId;
	
	
	
}
