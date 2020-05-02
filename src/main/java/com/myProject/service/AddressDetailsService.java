package com.myProject.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myProject.dto.GoogleAddressClient;
import com.myProject.dto.MockClient;
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
	
	@Autowired
	MockClientService mockClientSer;

	AddressDetails addrDetails = new AddressDetails();

	private static final String STATUS_FOUND = "ADDRESS_FOUND";
	private static final String STATUS_MOCK = "ADDRESS_MOCK";


	public AddressDetails returnAddressDetails(String reqAddress) {

		addrDetails.setRequestAddress(reqAddress);
		return mapAddressDetails(googleAddrClientSer.getGoogleAddressAPI(reqAddress), reqAddress);

	}
	

	/**
	 * Iterate through the gogleAddrClient to set the address
	 * 
	 * @param googleAddrClient
	 * @return addrDetails
	 */
	public AddressDetails mapAddressDetails(GoogleAddressClient googleAddrClient, String reqAddress) {
		ArrayList<String> resAddressList = new ArrayList<>();
		if (googleAddrClient != null && googleAddrClient.getResults() != null
				&& googleAddrClient.getResults().size() > 0) {
			addrDetails.setStatus(STATUS_FOUND);
			// Java 1.8 Lamda for collections
			googleAddrClient.getResults().forEach(result -> resAddressList.add(result.getFormatted_address()));
		} else {
			addrDetails.setStatus(STATUS_MOCK);
			resAddressList.add(0, invokeMockClient(reqAddress)); 
		}
		addrDetails.setAddressLists(resAddressList);
		return addrDetails;
	}
	
	/**
	 * Mocking the service to return random string from 
	 * 
	 * @param reqAddress
	 * @return mockAddress
	 */
	public  String invokeMockClient(String reqAddress) {		
		int mockParam = 0;
		for (int i = 0; i < reqAddress.length(); i++){
		    mockParam += (int)reqAddress.charAt(i);
		    while(mockParam > 200){
		    	mockParam = mockParam /10;
		    }
		}
		MockClient mockClient = mockClientSer.getMockAPI(mockParam);
		return mockClient.getTitle();
	}
	
}
