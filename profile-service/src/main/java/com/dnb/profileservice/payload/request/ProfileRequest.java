package com.dnb.profileservice.payload.request;

import com.dnb.profileservice.dto.SocialNetworkLinks;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProfileRequest {
	@Column(nullable = false)
	@NotBlank(message = "Professional status should not be blank")
	private String professionalStatus;//not null
	private String company;
	private String website;
	private String location;
	@Column(nullable = false)
	@NotBlank(message = "Skills should not be blank")
	private String skills;//not null
	private String gitUsername;
	private String bio;
	private SocialNetworkLinks links;
//	private String twitterURL;
//	private String facebookURL;
//	private String youTubeURL;
//	private String linkedinURL;
//	private String instagramURL;
	@NotNull
	private String userId;
}
