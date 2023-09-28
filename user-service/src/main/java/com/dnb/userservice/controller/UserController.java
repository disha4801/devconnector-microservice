package com.dnb.userservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnb.userservice.dto.User;
import com.dnb.userservice.exceptions.DataNotFoundException;
import com.dnb.userservice.exceptions.IdNotFoundException;
import com.dnb.userservice.exceptions.InvalidIdException;
import com.dnb.userservice.mapper.RequestToEntityMapper;
import com.dnb.userservice.payload.request.UserRequest;
import com.dnb.userservice.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	RequestToEntityMapper requestToEntityMapper;
	
	@PostMapping("/create")
	public ResponseEntity<?>createUser(@Valid @RequestBody UserRequest userRequest){
		User user=requestToEntityMapper.getUserEntityObject(userRequest);
		if(user.getConfirmPassword().equals(user.getPassword())) {
			User user2=userService.createUser(user);
			return new ResponseEntity(user2,HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity(HttpStatus.UNAUTHORIZED);
		}
	}
	
	@GetMapping("/usr/{userId}")
	public ResponseEntity<?>getUserById(@PathVariable("userId")String userId) throws InvalidIdException{
		Optional<User>optional=userService.getUserByUserId(userId);
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		else {
			throw new InvalidIdException("User id is not valid");
		}
	}
	
	@GetMapping("/allUsers")
	public ResponseEntity<?> getAllUsers() throws DataNotFoundException{
		List<User>users=(List<User>) userService.getAllUsers();
		if(users.isEmpty()) {
			throw new DataNotFoundException("No data found");
		}
		else {
			return ResponseEntity.ok(users);
		}
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUserById(@PathVariable("userId")String userId) throws IdNotFoundException, InvalidIdException{
		if(userService.userExistsById(userId)) {
			userService.deleteUserById(userId);
			return (ResponseEntity<?>) ResponseEntity.noContent().build();
		}
		else {
			throw new InvalidIdException("User id is not valid");
		}
	}
}
