package com.dnb.experienceservice.mapper;

import org.springframework.stereotype.Component;

import com.dnb.experienceservice.dto.Experience;
import com.dnb.experienceservice.payload.request.ExperienceRequest;


@Component
public class RequestToEntityMapper {
	
	public Experience getExperienceEntityObject(ExperienceRequest experienceRequest) {
		Experience experience=new Experience();
		experience.setJobTitle(experienceRequest.getJobTitle());
		experience.setCompany(experienceRequest.getCompany());
		experience.setLocation(experienceRequest.getLocation());
		experience.setFromDate(experienceRequest.getFromDate());
		experience.setCurrentJob(experienceRequest.getCurrentJob());
		experience.setToDate(experienceRequest.getToDate());
		experience.setJobDescription(experienceRequest.getJobDescription());
		experience.setProfileUUID(experienceRequest.getProfileUUID());
		return experience;
	}
	
}