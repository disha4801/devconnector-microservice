package com.dnb.profileservice.dto;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class SocialNetworkLinks {
	private String twitterUrl;
	private String facebookUrl;
	private String youtubeUrl;
	private String linkedinUrl;
	private String instagramUrl;
}
