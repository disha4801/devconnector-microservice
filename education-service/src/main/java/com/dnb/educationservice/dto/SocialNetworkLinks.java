package com.dnb.educationservice.dto;

import jakarta.persistence.Embeddable;
import lombok.Data;
@Data
@Embeddable
public class SocialNetworkLinks {
	private String twitterURL;
	private String facebookURL;
	private String youTubeURL;
	private String linkedinURL;
	private String instagramURL;
}
