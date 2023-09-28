package com.dnb.educationservice.dto;

import java.time.LocalDate;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Parameter;

import com.dnb.educationservice.utils.CustomIdGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Entity
public class Education {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "education_seq")
	
	@GenericGenerator(name = "education_seq", strategy = "com.dnb.educationservice.utils.CustomIdGenerator",
	parameters =  {@Parameter(name=CustomIdGenerator.INCREMENT_PARAM,value="50"),
			@Parameter(name=CustomIdGenerator.VALUE_PREFIX_PARAMETER,value="Edu_"),
			@Parameter(name=CustomIdGenerator.FLAG_PARAMETER,value="true"),
			@Parameter(name=CustomIdGenerator.NUMBER_FORMAT_PARAMETER,value="%05d")}
			)
	private String educationId;
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
	private String profileUUID;
	
//	@ManyToOne(fetch=FetchType.LAZY)
////	@OnDelete(action = OnDeleteAction.SET_NULL)
//	@JoinColumn(name="profileuuid",referencedColumnName="profileUUID")
//	@JsonIgnore
//	private Profile profile;
	
}
