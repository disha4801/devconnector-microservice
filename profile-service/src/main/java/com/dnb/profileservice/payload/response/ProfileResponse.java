package com.dnb.profileservice.payload.response;

import java.util.List;

import com.dnb.profileservice.dto.SocialNetworkLinks;
import com.dnb.profileservice.enums.ProfessionalStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
public class ProfileResponse {

	private long profileId;
	private ProfessionalStatus professionalStatus;
	private String company;
	private String location;
	private String websiteUrl;
	private List<String> skills;
	private String githubUserName;
	private String bio;
	private SocialNetworkLinks socialNetwork;

	private Integer userId;
	
	@JsonIgnoreProperties("profileId")
	private List<Experience> experience;
	@JsonIgnoreProperties("profileId")
	private List<Education> education;
	

}
