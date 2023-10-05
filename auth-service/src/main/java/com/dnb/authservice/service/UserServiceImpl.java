package com.dnb.authservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dnb.authservice.dto.User;
import com.dnb.authservice.repo.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Value("${api.profile}")
	private String profileURL;

	public void saveUser(User user) {
		userRepository.save(user);
	}

	public Optional<User> findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public Boolean existsByUsername(String username) {
		return userRepository.existsByUsername(username);
	}

	public Boolean existsByEmail(String email) {
		return userRepository.existsByEmail(email);
	}

	public Boolean existsById(int id) {
		return userRepository.existsById(id);
	}

	public Optional<User> findById(int userId) {
		return userRepository.findById(userId);
	}

	public void deleteByUserId(int userId) {
		userRepository.deleteById(userId);
		restTemplate.delete(profileURL + "/user" + String.valueOf(userId));
	}
}
