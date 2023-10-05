package com.dnb.experienceservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dnb.experienceservice.dto.Experience;
import com.dnb.experienceservice.dto.Profile;
import com.dnb.experienceservice.exceptions.IdNotFoundException;
import com.dnb.experienceservice.repo.ExperienceRepository;


@Service("experienceServiceImpl")
public class ExperienceServiceImpl implements ExperienceService {

	@Autowired
	private ExperienceRepository experienceRepository;
	
	@Autowired
	RestTemplate restTemplate;
//	
//	@Autowired
//	ApiClient apiClient;

	@Value("${api.profile}")
	private String URL;
	
	@Override
	public Experience createExperience(Experience experience) throws IdNotFoundException {
//		Optional<Profile>profile=profileRepository.findById(experience.getProfile().getProfileUUID());
//		
//		if(profile.isPresent()) {
//			experience.setProfile(profile.get());
//			return experienceRepository.save(experience);
//		}
//		else {
//			profile.orElseThrow(()->new IdNotFoundException("Profile id is not valid"));
//		}
		try {

			ResponseEntity<Profile> responseEntity = restTemplate.getForEntity(URL + "/" + experience.getProfileUUID(),
								Profile.class);
//	 		if(customer.isPresent()) {
//	 			account.setCustomer(customer.get());
//			System.out.println(responseEntity.getBody());
			return experienceRepository.save(experience);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public Optional<Experience> getExperienceById(String experienceId) {
		// TODO Auto-generated method stub
		return experienceRepository.findById(experienceId);
	}

	@Override
	public Iterable<Experience> getAllExperiences() {
		// TODO Auto-generated method stub
		return experienceRepository.findAll();
	}

	@Override
	public boolean deleteExperienceById(String experienceID) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if(experienceRepository.existsById(experienceID)) {
			experienceRepository.deleteById(experienceID);
			if(experienceRepository.existsById(experienceID)) {
				return false;
			}
			return true;
		}
		else {
			throw new IdNotFoundException("ID Not found");
		}
	}
	
	@Override
	public boolean experienceExistsById(String experienceId) {
		if(experienceRepository.existsById(experienceId))return true;
		else return false;
	}

}
