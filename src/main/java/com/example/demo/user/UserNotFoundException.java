package com.example.demo.user;

public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3531834114987519666L;

	public UserNotFoundException(String str) {
		super(str);
	}

	public UserNotFoundException() {
		super();
	}
	
	
}
