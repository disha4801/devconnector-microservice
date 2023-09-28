package com.dnb.experienceservice.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dnb.experienceservice.dto.Experience;

@Repository
public interface ExperienceRepository extends CrudRepository<Experience, String> {

}
