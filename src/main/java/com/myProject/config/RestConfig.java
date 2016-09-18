package com.myProject.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author Nijin Illath
 *
 */

@Configuration
public class RestConfig {

	/**
	 * RestTemplate to post the HTTP requests
	 * 
	 * @return
	 */
	@Bean
	public RestOperations createRestTemplate(ClientHttpRequestFactory clientHttpRequestFactory) {
		return new RestTemplate(clientHttpRequestFactory);
	}

	/**
	 * RestTemplate does not have any connect or read time out so need to
	 * mention it explicitly to handle it in our service calls
	 */

	@Bean
	public ClientHttpRequestFactory createClientHttpRequestFactory(
			@Value("${connect.timeout}") final int connectTimeout, @Value("${read.timeout}") final int readTimeout) {
		HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		httpComponentsClientHttpRequestFactory.setReadTimeout(readTimeout);
		httpComponentsClientHttpRequestFactory.setConnectTimeout(connectTimeout);
		return httpComponentsClientHttpRequestFactory;
	}
}
