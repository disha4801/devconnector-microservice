package com.dnb.profileservice.payload.request;

import java.util.List;

import com.dnb.profileservice.dto.SocialNetworkLinks;
import com.dnb.profileservice.enums.ProfessionalStatus;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProfileRequest {

	@Enumerated(EnumType.STRING)
	@NotNull(message = "Professional Status should not be blank")
	private ProfessionalStatus professionalStatus;

	private String company;
	private String location;
	private String websiteUrl;

	@NotEmpty(message = "skills cannot be empty")
	private List<String> skills;

	private String githubUserName;
	private String bio;

	private SocialNetworkLinks socialNetwork;

	private Integer userId;
}
