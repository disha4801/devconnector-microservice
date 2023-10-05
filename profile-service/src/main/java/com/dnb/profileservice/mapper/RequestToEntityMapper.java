package com.dnb.profileservice.mapper;

import org.springframework.stereotype.Component;

import com.dnb.profileservice.dto.Profile;

@Component
public class RequestToEntityMapper {

	public Profile profileRequestToEntity(com.dnb.profileservice.payload.request.ProfileRequest profileRequest) {

		com.dnb.profileservice.dto.Profile profile = new Profile();

		profile.setProfessionalStatus(profileRequest.getProfessionalStatus());
		profile.setCompany(profileRequest.getCompany());
		profile.setLocation(profileRequest.getLocation());
		profile.setBio(profileRequest.getBio());
		profile.setWebsiteUrl(profileRequest.getWebsiteUrl());
		profile.setGithubUserName(profileRequest.getGithubUserName());

		profile.setSkills(profileRequest.getSkills());

		profile.setSocialNetwork(profileRequest.getSocialNetwork());

		profile.setUserId(profileRequest.getUserId());

		return profile;
	}

}
