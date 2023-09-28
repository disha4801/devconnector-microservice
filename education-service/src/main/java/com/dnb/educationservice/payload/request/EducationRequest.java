package com.dnb.educationservice.payload.request;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EducationRequest {
	@Column(nullable = false)
	@NotBlank(message = "School or bootcamp should not be blank")
	private String school;//not null
	@Column(nullable = false)
	@NotBlank(message = "Degree or certificate should not be blank")
	private String degree;//not null
	private String fieldOfStudy;
	private LocalDate fromDate;
	private Boolean currentSchool;
	private LocalDate toDate;
	private String progDescription;
	@NotNull
	private String profileUUID;
}
