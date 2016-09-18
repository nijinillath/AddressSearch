package com.myProject.dto;

import java.util.ArrayList;

/**
 * 
 * @author Nijin Illath
 *
 */

public class GoogleAddressClient {
	ArrayList<Results> results = new ArrayList<>();
	String status;

	public ArrayList<Results> getResults() {
		return results;
	}

	public void setResults(ArrayList<Results> results) {
		this.results = results;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
