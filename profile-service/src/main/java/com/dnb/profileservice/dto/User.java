package com.dnb.profileservice.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	
	@Id
	private String userId;
	private String name;
	private String emailId;
	private String password;
	private String confirmPassword;
	private Profile profile;

}
