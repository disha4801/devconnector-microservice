package com.dnb.profileservice.payload.response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Experience {

	private String experienceId;

	private String jobTitle;

	private String company;
	private String location;

	private LocalDate fromDate;
	private boolean currentJob;

	private LocalDate toDate;

	private String jobDescription;

	private String profileId;
}
