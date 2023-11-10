package com.rest.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class ClientConfig {

	@Value("${server.base.url}")
	private String BASE_URL;
	@Bean
	public RestClient client() {
		return RestClient
				.builder()
				.baseUrl(BASE_URL)
				.build();
	}
}
