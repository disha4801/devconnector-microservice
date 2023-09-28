package com.dnb.educationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class EducationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EducationServiceApplication.class, args);
	}

	@Bean
//	@Scope("prototype")
	@LoadBalanced
	public RestTemplate restTemplate() {//synchronous communication
		return new RestTemplate();
	}
}
