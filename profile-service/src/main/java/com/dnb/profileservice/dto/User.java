package com.dnb.profileservice.dto;

import lombok.Data;

@Data
public class User {

	private Integer userId;
	private String emailId;
	private String userName;
	private String password;
}
