package com.dnb.userservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.userservice.dto.User;
import com.dnb.userservice.exceptions.IdNotFoundException;
import com.dnb.userservice.repo.UserRepository;


@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public Optional<User> getUserByUserId(String userId) {
		// TODO Auto-generated method stub
		return userRepository.findById(userId);
	}

	@Override
	public Iterable<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public boolean deleteUserById(String userId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if(userRepository.existsById(userId)) {
			userRepository.deleteById(userId);
			if(userRepository.existsById(userId)) {
				return false;
			}
			return true;
		}
		else {
			throw new IdNotFoundException("ID not found");
		}
	}
	
	@Override
	public boolean userExistsById(String userId) {
		// TODO Auto-generated method stub
		if(userRepository.existsById(userId))return true;
		else return false;
	}
	
}
