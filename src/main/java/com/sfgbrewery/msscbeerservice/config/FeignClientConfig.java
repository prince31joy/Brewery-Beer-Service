package com.sfgbrewery.msscbeerservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class FeignClientConfig {

	@Bean
	public BasicAuthRequestInterceptor basicAuthRequestInterceptor(
			@Value("${sfg.brewery.inventory-user}") String inventoryUser,
			@Value("${sfg.brewery.inventory-password}") String inventoryPassword) {
		
		return new BasicAuthRequestInterceptor(inventoryUser, inventoryPassword);
	}

}
