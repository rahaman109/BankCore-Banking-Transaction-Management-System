package com.alpha.accountservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class CustomerClientConfig {

	
	@Bean
	public RestClient customerRestClient()
	{
		return RestClient.builder().baseUrl("http://localhost:8082").build();
	}
}
