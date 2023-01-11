package com.example.user.service;

import com.example.user.Vo.UserResponse;
import com.example.user.entity.User;

public interface UserService {

	public User saveUser(User user) throws Exception;

	public UserResponse getUserwithDepartment(long id) throws Exception;

}
