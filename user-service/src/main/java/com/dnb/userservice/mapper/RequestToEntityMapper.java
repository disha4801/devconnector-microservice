package com.dnb.userservice.mapper;

import org.springframework.stereotype.Component;

import com.dnb.userservice.dto.User;
import com.dnb.userservice.payload.request.UserRequest;

@Component
public class RequestToEntityMapper {
	
	public User getUserEntityObject(UserRequest userRequest) {
		User user= new User();
		user.setName(userRequest.getName());
		user.setEmailId(userRequest.getEmailId());
		user.setPassword(userRequest.getPassword());
		user.setConfirmPassword(userRequest.getConfirmPassword());
		return user;
	}
	
}