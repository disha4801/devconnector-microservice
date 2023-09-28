package com.dnb.profileservice.mapper;

import org.springframework.stereotype.Component;

import com.dnb.profileservice.dto.Profile;
import com.dnb.profileservice.payload.request.ProfileRequest;

@Component
public class RequestToEntityMapper {
	
	
	public Profile getProfileEntityObject(ProfileRequest profileRequest) {
		Profile profile=new Profile();
		profile.setProfessionalStatus(profileRequest.getProfessionalStatus());
		profile.setCompany(profileRequest.getCompany());
		profile.setWebsite(profileRequest.getWebsite());
		profile.setLocation(profileRequest.getLocation());
		profile.setSkills(profileRequest.getSkills());
		profile.setGitUsername(profileRequest.getGitUsername());
		profile.setBio(profileRequest.getBio());
		profile.setLinks(profileRequest.getLinks());
		profile.setUserId(profileRequest.getUserId());
		
		return profile;
	}
	
}