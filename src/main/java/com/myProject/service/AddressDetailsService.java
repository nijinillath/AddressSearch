package com.myProject.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myProject.dto.GoogleAddressClient;
import com.myProject.model.AddressDetails;

/**
 * 
 * @author Nijin Illath Service class to call the google map search API and set
 *         the required values to the REST response.
 *
 */
@Service
public class AddressDetailsService {

	@Autowired
	GoogleAddressClientService googleAddrClientSer;

	AddressDetails addrDetails = new AddressDetails();

	private static final String STATUS_NOT_FOUND = "ADDRESS_NOT_FOUND";
	private static final String STATUS_FOUND = "ADDRESS_FOUND";

	public AddressDetails returnAddressDetails(String reqAddress) {

		addrDetails.setRequestAddress(reqAddress);
		return mapAddressDetails(googleAddrClientSer.getGoogleAddressAPI(reqAddress));

	}

	/**
	 * Iterate through the gogleAddrClient to set the address
	 * 
	 * @param googleAddrClient
	 * @return addrDetails
	 */
	public AddressDetails mapAddressDetails(GoogleAddressClient googleAddrClient) {
		ArrayList<String> resAddressList = new ArrayList<>();
		if (googleAddrClient != null && googleAddrClient.getResults() != null
				&& googleAddrClient.getResults().size() > 0) {
			addrDetails.setStatus(STATUS_FOUND);
			// Java 1.8 Lamda for collections
			googleAddrClient.getResults().forEach(result -> resAddressList.add(result.getFormatted_address()));
		} else {
			addrDetails.setStatus(STATUS_NOT_FOUND);
		}
		addrDetails.setAddressLists(resAddressList);
		return addrDetails;
	}
}
