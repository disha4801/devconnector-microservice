package com.dnb.profileservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dnb.profileservice.dto.Profile;
import com.dnb.profileservice.dto.User;
import com.dnb.profileservice.exceptions.IdNotFoundException;
import com.dnb.profileservice.repo.ProfileRepository;

@Service("profileServiceImpl")
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileRepository profileRepository;
	
	@Autowired
	RestTemplate restTemplate;
//	
//	@Autowired
//	ApiClient apiClient;

	@Value("${api.user}")
	private String URL;
	
	@Override
	public Profile createProfile(Profile profile) throws IdNotFoundException {
		// TODO Auto-generated method stub
//		Optional<User>user=userRepository.findById(profile.getUser().getUserId());
//		
//		if(user.isPresent()) {
//			profile.setUser(user.get());
//			return profileRepository.save(profile);
//		}
//		else {
//			user.orElseThrow(()->new IdNotFoundException("User id is not valid"));
//		}
		try {
			ResponseEntity<User> responseEntity = restTemplate.getForEntity(URL + "/usr/" + profile.getUserId(),
					User.class);
//	 		if(customer.isPresent()) {
//	 			account.setCustomer(customer.get());
//			System.out.println(responseEntity.getBody());
			return profileRepository.save(profile);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public Optional<Profile> getProfileById(String profileUUId) {
		// TODO Auto-generated method stub
		return profileRepository.findById(profileUUId);
	}

	@Override
	public Iterable<Profile> getAllProfiles() {
		// TODO Auto-generated method stub
		return profileRepository.findAll();
	}

	@Override
	public boolean deleteProfileById(String profileUUID) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if(profileRepository.existsById(profileUUID)) {
			profileRepository.deleteById(profileUUID);
			if(profileRepository.existsById(profileUUID)) {
				return false;
			}
			return true;
		}
		else {
			throw new IdNotFoundException("ID Not found");
		}
	}

	@Override
	public boolean profileExistsById(String profileId) {
		if(profileRepository.existsById(profileId))return true;
		else return false;
	}
}
