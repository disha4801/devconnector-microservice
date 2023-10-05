package com.dnb.profileservice.payload.response;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Education {

	private String educationId;

	private String schoolName;

	private String degreeName;

	private String fieldOfStudy;

	private LocalDate fromDate;
	private boolean currentSchool;

	private LocalDate toDate;

	private String programDescription;

	private String profileId;

}
