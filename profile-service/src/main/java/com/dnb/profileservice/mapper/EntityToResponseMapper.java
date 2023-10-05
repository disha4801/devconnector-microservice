package com.dnb.profileservice.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.dnb.profileservice.dto.Profile;
import com.dnb.profileservice.payload.response.Education;
import com.dnb.profileservice.payload.response.Experience;
import com.dnb.profileservice.payload.response.ProfileResponse;

@Component
public class EntityToResponseMapper {

//	@Autowired
//	private Converter converter;

	public ProfileResponse helper(Profile profile) {
		ProfileResponse profileResponse = new ProfileResponse();

		profileResponse.setProfileId(profile.getProfileId());
		profileResponse.setProfessionalStatus(profile.getProfessionalStatus());

		profileResponse.setCompany(profile.getCompany());
		profileResponse.setBio(profile.getBio());
		profileResponse.setLocation(profile.getLocation());
		profileResponse.setGithubUserName(profile.getGithubUserName());

		profileResponse.setSkills(profile.getSkills());

		profileResponse.setSocialNetwork(profile.getSocialNetwork());
		profileResponse.setUserId(profile.getUserId());

		return profileResponse;
	}

	public ProfileResponse profileEntityToResponse(Profile profile, List<Experience> experience,
			List<Education> education) {

		ProfileResponse profileResponse = this.helper(profile);
		profileResponse.setEducation(education);
		profileResponse.setExperience(experience);
		return profileResponse;
	}

	public ProfileResponse profileEntityToResponse(Profile profile) {

		ProfileResponse profileResponse = this.helper(profile);
		return profileResponse;
	}
}
