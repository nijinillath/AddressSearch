package com.myProject.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

import com.myProject.dto.MockClient;

/**
 * 
 * @author Nijin Illath Component class to invoke the google map API.
 *
 */

@Component
public class MockClientService {

	private static final Logger logger = Logger.getLogger(MockClientService.class);

	@Autowired
	private RestOperations restOperations;

	private final String url;

	@Autowired
	public MockClientService(@Value("${mock.api.url}") String url) {
		this.url = url;
	}

	public MockClient getMockAPI(int param) {
		logger.info(" mock url " + url);
		MockClient mockCleint =  restOperations.getForObject(url, MockClient.class, param);
		return mockCleint;
	}

}
