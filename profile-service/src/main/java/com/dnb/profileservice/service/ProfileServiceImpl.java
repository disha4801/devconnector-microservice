package com.dnb.profileservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dnb.profileservice.dto.Profile;
import com.dnb.profileservice.dto.User;
import com.dnb.profileservice.exceptions.IdNotFoundException;
import com.dnb.profileservice.exceptions.ProfileMappingException;
import com.dnb.profileservice.payload.response.Education;
import com.dnb.profileservice.payload.response.Experience;
import com.dnb.profileservice.repo.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileRepository profileRepository;

//	@org.springframework.beans.factory.annotation.Value("${api.user}")
//	private String userURL;

	@org.springframework.beans.factory.annotation.Value("${api.education}")
	private String educationURL;

	@org.springframework.beans.factory.annotation.Value("${api.experience}")
	private String experienceURL;

	@org.springframework.beans.factory.annotation.Value("${api.auth}")
	private String authUrl;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Profile createProfile(Profile profile) throws IdNotFoundException, ProfileMappingException {

		try {
//			restTemplate.getForEntity(userURL + "/" + String.valueOf(profile.getUserId()), User.class);
			restTemplate.getForEntity(authUrl + "/" + String.valueOf(profile.getUserId()), User.class);

			int size = profileRepository.findByUserId(profile.getUserId()).size();
			if (size > 0)
				throw new ProfileMappingException(
						"Provided User Already has Profile. One user can have only one profile!!");

			Profile profile2 =  profileRepository.save(profile);
			System.out.println(profile2);
			return profile2;

		} catch (ProfileMappingException e) {
			throw new ProfileMappingException(
					"Provided User Already has Profile. One user can have only one profile!!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new IdNotFoundException("UserId Not Found!!");
		}
	}

	@Override
	public Optional<Profile> getProfileById(long profileId) {
		return profileRepository.findById(profileId);
	}

	@Override
	public Iterable<Profile> getAllProfiles() {
		return profileRepository.findAll();
	}

	@Override
	public boolean deleteProfileById(long profileId) throws IdNotFoundException {

		boolean isExists = profileRepository.existsById(profileId);
		profileRepository.findById(profileId);
		if (!isExists)
			throw new IdNotFoundException("Profile Id not found!");

		profileRepository.deleteById(profileId);
		if (profileRepository.existsById(profileId))
			return false;
		else {
			restTemplate.delete(experienceURL + "/profileId/" + profileId);
			restTemplate.delete(educationURL + "/profileId/" + profileId);
			return true;
		}
	}

	@Override
	public void deleteByUserId(Integer userId) {
		profileRepository.deleteByUserId(userId);
	}

	public List<Experience> getExperienceByProfileId(long profileId) {

		List<Experience> experience = (List<Experience>) restTemplate
				.getForEntity(experienceURL + "/All/" + profileId, List.class).getBody();
		return experience;
	}

	@Override
	public List<Education> getEducationByProfileId(long profileId) {

		List<Education> experience = (List<Education>) restTemplate
				.getForEntity(educationURL + "/All/" + profileId, List.class).getBody();
		return experience;
	}

	@Override
	public List<Profile> getProfileByUserId(int userId) {
		return profileRepository.findByUserId(userId);
	}

	@Override
	public boolean checkProfileIdExists(Long profileId) {
		// TODO Auto-generated method stub
		return this.profileRepository.existsById(profileId);
	}
	
	

}
