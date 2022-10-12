package com.mmt.user.exceptions;

public class UserIncorrectSignUpException extends Exception{

	private static final long serialVersionUID = 1L;

	public UserIncorrectSignUpException(String message) {
		super(message);
	}

}
