package com.dnb.profileservice.service;

import java.util.List;
import java.util.Optional;

import com.dnb.profileservice.dto.Profile;
import com.dnb.profileservice.exceptions.IdNotFoundException;
import com.dnb.profileservice.exceptions.ProfileMappingException;
import com.dnb.profileservice.payload.response.Education;
import com.dnb.profileservice.payload.response.Experience;

public interface ProfileService {

	public Profile createProfile(Profile profile) throws IdNotFoundException, ProfileMappingException;

	public Iterable<Profile> getAllProfiles();

	public boolean deleteProfileById(long profileId) throws IdNotFoundException;

	public void deleteByUserId(Integer userId);

	public List<Education> getEducationByProfileId(long profileId);

	public List<Experience> getExperienceByProfileId(long profileId);
	
	public List<Profile> getProfileByUserId(int userId);
	
	public boolean checkProfileIdExists(Long profileId);

	public Optional<Profile> getProfileById(long profileId);
	

}
