package com.dnb.educationservice.dto;

import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profile {
	private String profileUUID;
	private String professionalStatus;//not null
	private String company;
	private String website;
	private String location;
	private String skills;//not null
	private String gitUsername;
	private String bio;
	@Embedded
	private SocialNetworkLinks links;
//	private String twitterURL;
//	private String facebookURL;
//	private String youTubeURL;
//	private String linkedinURL;
//	private String instagramURL;
	private String userId;
}
