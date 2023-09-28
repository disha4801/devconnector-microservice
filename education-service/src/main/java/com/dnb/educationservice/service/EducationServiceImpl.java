package com.dnb.educationservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dnb.educationservice.dto.Education;
import com.dnb.educationservice.dto.Profile;
import com.dnb.educationservice.exceptions.IdNotFoundException;
import com.dnb.educationservice.repo.EducationRepository;


@Service("educationServiceImpl")
public class EducationServiceImpl implements EducationService {

	@Autowired
	private EducationRepository educationRepository;
	

	@Autowired
	RestTemplate restTemplate;
	
	@Value("${api.profile}")
	private String URL;
	
	@Override
	public Education createEducationProfile(Education education) throws IdNotFoundException {
		// TODO Auto-generated method stub
//		Optional<Profile>profile=profileRepository.findById(education.getProfile().getProfileUUID());
//		
//		if(profile.isPresent()) {
//			education.setProfile(profile.get());
//			return educationRepository.save(education);
//		}
//		else {
//			profile.orElseThrow(()->new IdNotFoundException("Profile id is not valid"));
//		}
		try {
			ResponseEntity<Profile> responseEntity = restTemplate.getForEntity(URL + "/edu/" + education.getProfileUUID(),
					Profile.class);
//	 		if(customer.isPresent()) {
//	 			account.setCustomer(customer.get());
//			System.out.println(responseEntity.getBody());
			return educationRepository.save(education);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public Optional<Education> getEducationProfileById(String educationId) {
		// TODO Auto-generated method stub
		return educationRepository.findById(educationId);
	}

	@Override
	public Iterable<Education> getAllEducations() {
		// TODO Auto-generated method stub
		return educationRepository.findAll();
	}

	@Override
	public boolean deleteEducationById(String educationID) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if(educationRepository.existsById(educationID)) {
			educationRepository.deleteById(educationID);
			if(educationRepository.existsById(educationID)) {
				return false;
			}
			return true;
		}
		else {
			throw new IdNotFoundException("ID not found");
		}
	}
	
	@Override
	public boolean educationExistsById(String educationId) {
		if(educationRepository.existsById(educationId))return true;
		else return false;
	}

}
