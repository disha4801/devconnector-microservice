package com.dnb.profileservice.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dnb.profileservice.dto.Profile;

import jakarta.transaction.Transactional;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long> {

	// delete from profile where userId = ?
	
	public void deleteByUserId(Integer userId);

	// select * from profile where userId = ?
	public List<Profile> findByUserId(Integer userId);

}
