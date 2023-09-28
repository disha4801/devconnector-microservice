package com.dnb.userservice.payload.request;

import jakarta.persistence.Column;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequest {

	private String name;
	//unique key constraint
	@Column(unique=true)
	private String emailId;
	@NotBlank(message = "Password should not be empty")
	@jakarta.validation.constraints.Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")
//	False: password
//	True: password123
//	False: pa$$word
//	False: 12345678
//	False: PASSWORD
//	False: P@ss
//	False: p@ss
	private String password;
	
	@Transient
	@jakarta.validation.constraints.Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")
	private String confirmPassword;
}
