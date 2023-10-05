package com.dnb.experienceservice.dto;

import java.time.LocalDate;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Parameter;

import com.dnb.experienceservice.utils.CustomIdGenerator;
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
public class Experience {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "experience_seq")
//	
//	@GenericGenerator(name = "experience_seq", strategy = "com.dnb.experienceservice.utils.CustomIdGenerator",
//	parameters =  {@Parameter(name=CustomIdGenerator.INCREMENT_PARAM,value="1000"),
//			@Parameter(name=CustomIdGenerator.FLAG_PARAMETER,value="true"),
//			@Parameter(name=CustomIdGenerator.VALUE_PREFIX_PARAMETER,value="Exp_"),
//			@Parameter(name=CustomIdGenerator.NUMBER_FORMAT_PARAMETER,value="%05d")}
//			)
	private long experienceId;//exp_date_number//https://thorben-janssen.com/custom-sequence-based-idgenerator/
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
	private String profileUUID;
	
//	@ManyToOne(fetch=FetchType.LAZY)
//	//@OnDelete(action = OnDeleteAction.SET_NULL)
//	@JoinColumn(name="profileuuid",referencedColumnName="profileUUID")
//	@JsonIgnore
//	private Profile profile;
}
