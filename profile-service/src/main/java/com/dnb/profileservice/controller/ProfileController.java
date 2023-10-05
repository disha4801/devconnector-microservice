package com.dnb.profileservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnb.profileservice.dto.Profile;
import com.dnb.profileservice.exceptions.IdNotFoundException;
import com.dnb.profileservice.exceptions.ProfileMappingException;
import com.dnb.profileservice.mapper.EntityToResponseMapper;
import com.dnb.profileservice.mapper.RequestToEntityMapper;
import com.dnb.profileservice.payload.request.ProfileRequest;
import com.dnb.profileservice.payload.response.Education;
import com.dnb.profileservice.payload.response.Experience;
import com.dnb.profileservice.payload.response.ProfileResponse;
import com.dnb.profileservice.service.ProfileService;

@RestController
@RequestMapping("api/profile")
public class ProfileController {

	@Autowired
	private ProfileService profileService;

	@Autowired
	private RequestToEntityMapper mapper;

	@Autowired
	private EntityToResponseMapper entityToResponseMapper;

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody ProfileRequest profileRequest)
			throws IdNotFoundException, ProfileMappingException {

		Profile profile;
		profile = mapper.profileRequestToEntity(profileRequest);
		System.out.println(profile);

		ProfileResponse createdProfile = entityToResponseMapper
				.profileEntityToResponse(profileService.createProfile(profile));
		return new ResponseEntity<ProfileResponse>(createdProfile, HttpStatus.CREATED);

	}

	@GetMapping("/{profileId}")
	public ResponseEntity<?> getProfileById(@PathVariable("profileId") long profileId) throws IdNotFoundException {

		Optional<Profile> profile = profileService.getProfileById(profileId);

		if (profile.isEmpty())
			throw new IdNotFoundException("ProfileId Not Found!!");

		List<Experience> experience = profileService.getExperienceByProfileId(profileId);
		List<Education> education = profileService.getEducationByProfileId(profileId);

		ProfileResponse profileResponse = entityToResponseMapper.profileEntityToResponse(profile.get(), experience,
				education);
		return ResponseEntity.ok(profileResponse);
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<?> findProfileByUserId(@PathVariable("userId") int userId) {

		List<Profile> profile = profileService.getProfileByUserId(userId);
		return ResponseEntity.ok(profile);
	}

	@DeleteMapping("/{profileId}")
	public ResponseEntity<?> deleteUserById(@PathVariable("profileId") long profileId) throws IdNotFoundException {

		profileService.deleteProfileById(profileId);

		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/user/{userId}")
	public ResponseEntity<?> deleteByUserId(@PathVariable("userId") Integer userId) {

		profileService.deleteByUserId(userId);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/check/{profileId}")
	public ResponseEntity<?> checkProfileIdExists(@PathVariable("profileId") long profileId) {
		profileService.checkProfileIdExists(profileId);
		return ResponseEntity.noContent().build();

	}
}