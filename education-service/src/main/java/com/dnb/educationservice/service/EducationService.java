package com.dnb.educationservice.service;

import java.util.Optional;

import com.dnb.educationservice.dto.Education;
import com.dnb.educationservice.exceptions.IdNotFoundException;


public interface EducationService {
	public Education createEducationProfile(Education education) throws IdNotFoundException;
	
	public Optional<Education> getEducationProfileById(String educationId);
	
	public Iterable<Education> getAllEducations();
	
	public boolean deleteEducationById(String educationID) throws IdNotFoundException;

	boolean educationExistsById(String educationId);
}
