package com.example.user.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.user.Vo.Department;
import com.example.user.Vo.UserResponse;
import com.example.user.entity.User;
import com.example.user.exception.FieldInvalidException;
import com.example.user.repository.UserRepository;
import com.example.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate rest;

	public User saveUser(User user) throws Exception {
		
		User email = userRepository.findByEmail(user.getEmail());
		if(email!=null) {
			throw new Exception("user is already present ");
		}else {
		
			return userRepository.save(user);
		}
	}

	public UserResponse getUserwithDepartment(long id) throws Exception {
		UserResponse userResponse = new UserResponse();
		User user = userRepository.findByUserId(id);
		
		if(user==null) {
			throw new FieldInvalidException("no content !");
		}
		
		Department department = rest.getForObject("http://department-service/departments/get/"+user.getDepartmentId(), Department.class);
		userResponse.setFirstName(user.getFirstName());
		userResponse.setUserId(user.getUserId());
		userResponse.setLastName(user.getLastName());
		userResponse.setEmail(user.getEmail());
		userResponse.setMobileNumber(user.getMobileNumber());
		userResponse.setDepartment(department);
		
		if(userResponse.getUserId()==null) {
			
			throw new Exception("User not found");
			
		}else {
		
			return userResponse;
		
		}
	}
}
