package com.dnb.experienceservice.service;

import java.util.Optional;

import com.dnb.experienceservice.dto.Experience;
import com.dnb.experienceservice.exceptions.IdNotFoundException;


public interface ExperienceService {
	public Experience createExperience(Experience experience) throws IdNotFoundException;
	
	public Optional<Experience> getExperienceById(String experienceId);
	
	public Iterable<Experience> getAllExperiences();
	
	public boolean deleteExperienceById(String experienceID) throws IdNotFoundException;

	boolean experienceExistsById(String experienceId);
}
