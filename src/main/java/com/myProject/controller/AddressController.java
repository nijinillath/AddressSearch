package com.myProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.myProject.exceptions.InvalidRequestException;
import com.myProject.model.AddressDetails;
import com.myProject.service.AddressDetailsService;

/**
 * 
 * @author Nijin Illath Controller for the REST input url posted.
 *
 */

@RestController
@RequestMapping(value = "/searchAddress")
public class AddressController {

	@Autowired
	AddressDetailsService addrServ;

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = { "/details" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public AddressDetails getAddressDetails(@RequestParam(value = "input", required = false) String address)
			throws InvalidRequestException {
		if (StringUtils.isEmpty(address)) {
			throw new InvalidRequestException("Please provide the address to search");
		}
		return addrServ.returnAddressDetails(address);
	}

}
