package com.dnb.userservice.service;

import java.util.Optional;

import com.dnb.userservice.dto.User;
import com.dnb.userservice.exceptions.IdNotFoundException;


public interface UserService {
	public User createUser(User user);
	
	public Optional<User> getUserByUserId(String userId);
	
	public Iterable<User> getAllUsers();
	
	public boolean deleteUserById(String userId) throws IdNotFoundException;

	public boolean userExistsById(String userId);
}
