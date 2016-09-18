package com.myProject.exceptions;

/**
 * 
 * @author Nijin Illath Customer exception to handle invalid request send while
 *         invoking the service.
 *
 */
public class InvalidRequestException extends RuntimeException {

	public InvalidRequestException() {
		super();
	}

	public InvalidRequestException(String message) {
		super(message);
	}

	public InvalidRequestException(String message, Exception ex) {
		super(message, ex);
	}
}
