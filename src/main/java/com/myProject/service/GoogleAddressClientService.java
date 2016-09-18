package com.myProject.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

import com.myProject.dto.GoogleAddressClient;

/**
 * 
 * @author Nijin Illath Component class to invoke the google map API.
 *
 */

@Component
public class GoogleAddressClientService {

	private static final Logger logger = Logger.getLogger(GoogleAddressClientService.class);

	@Autowired
	private RestOperations restOperations;

	private final String url;

	@Autowired
	public GoogleAddressClientService(@Value("${google.map.api.url}") String url) {
		this.url = url;
	}

	public GoogleAddressClient getGoogleAddressAPI(String reqAddress) {
		logger.info(" google url " + url);
		return restOperations.getForObject(url, GoogleAddressClient.class, reqAddress);

	}

}
