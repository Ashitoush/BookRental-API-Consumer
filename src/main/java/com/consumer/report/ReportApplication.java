package com.consumer.report;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ReportApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReportApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}
