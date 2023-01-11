package com.example.user.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

	private Long userId;

	private String firstName;

	private String lastName;

	private String email;

	private String mobileNumber;

	private Department department;

	
	
	
}
