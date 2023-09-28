package com.dnb.experienceservice.payload.request;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ExperienceRequest {
	@Column(nullable = false)
	@NotBlank(message = "jobTitle should not be blank")
	private String jobTitle;
	@Column(nullable = false)
	@NotBlank(message = "Company name should not be blank")
	private String company;
	private String location;
	private LocalDate fromDate;
	private Boolean currentJob;
	private LocalDate toDate;
	private String jobDescription;
	@NotNull
	private String profileUUID;
}
