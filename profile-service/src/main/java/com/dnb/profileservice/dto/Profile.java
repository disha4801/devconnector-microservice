package com.dnb.profileservice.dto;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.dnb.profileservice.enums.ProfessionalStatus;
import com.dnb.profileservice.utils.CustomIdGenerator;
import com.dnb.profileservice.utils.SkillsConverter;

import jakarta.persistence.Convert;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Profile {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long profileId;

	@Enumerated(EnumType.STRING)
	@NotNull(message = "Professional Status should not be blank")
	private ProfessionalStatus professionalStatus;

	private String company;
	private String location;
	private String websiteUrl;

	@Convert(converter = SkillsConverter.class)
	@NotEmpty(message = "skills cannot be empty")
	private List<String> skills;

	private String githubUserName;
	private String bio;

	@Embedded
	private SocialNetworkLinks socialNetwork;

	private Integer userId;

}
