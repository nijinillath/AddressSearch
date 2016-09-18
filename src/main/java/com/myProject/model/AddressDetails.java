package com.myProject.model;

import java.util.ArrayList;

/**
 * 
 * @author Nijin Illath
 *
 */
public class AddressDetails {
	String requestAddress;
	String status;
	ArrayList<String> addressLists;

	public String getRequestAddress() {
		return requestAddress;
	}

	public void setRequestAddress(String requestAddress) {
		this.requestAddress = requestAddress;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ArrayList<String> getAddressLists() {
		return addressLists;
	}

	public void setAddressLists(ArrayList<String> addressLists) {
		this.addressLists = addressLists;
	}

}
