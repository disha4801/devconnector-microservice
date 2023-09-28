package com.dnb.profileservice.mapper;

import org.springframework.stereotype.Component;

import com.dnb.profileservice.dto.Profile;
import com.dnb.profileservice.payload.response.ProfileResponse;
import com.dnb.profileservice.utils.Converter;

@Component
public class EntityToResponseMapper {

	
	Converter converter=new Converter();
	
	public ProfileResponse setProfileResponseObject(Profile profile) {
		ProfileResponse profileResponse=new ProfileResponse();
		profileResponse.setProfileUUID(profile.getProfileUUID());
		profileResponse.setProfessionalStatus(profile.getProfessionalStatus());
		profileResponse.setCompany(profile.getCompany());
		profileResponse.setWebsite(profile.getWebsite());
		profileResponse.setLocation(profile.getLocation());
		profileResponse.setSkills(converter.stringToArray(profile.getSkills()));
		profileResponse.setGitUsername(profile.getGitUsername());
		profileResponse.setBio(profile.getBio());
		profileResponse.setLinks(profile.getLinks());
		profileResponse.setUserId(profile.getUserId());
		return profileResponse;
	}
}
