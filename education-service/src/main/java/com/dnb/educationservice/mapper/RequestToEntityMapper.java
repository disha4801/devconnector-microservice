package com.dnb.educationservice.mapper;

import org.springframework.stereotype.Component;

import com.dnb.educationservice.dto.Education;


@Component
public class RequestToEntityMapper {
	
	public Education getEducationEntityObject(com.dnb.educationservice.payload.request.EducationRequest educationRequest) {
		com.dnb.educationservice.dto.Education education=new Education();
		education.setSchool(educationRequest.getSchool());
		education.setDegree(educationRequest.getDegree());
		education.setFieldOfStudy(educationRequest.getFieldOfStudy());
		education.setFromDate(educationRequest.getFromDate());
		education.setCurrentSchool(educationRequest.getCurrentSchool());
		education.setToDate(educationRequest.getToDate());
		education.setProgDescription(educationRequest.getProgDescription());
		education.setProfileUUID(educationRequest.getProfileUUID());
		
		return education;
	}
	
	
}