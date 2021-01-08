package com.blz.bookstore.exceptions;

public class UserException extends Exception {
	
	private String message;
	
	public enum ExceptionType{
		INVALID_USER,INVALID_CREDENTIALS,ALREADY_VERIFIED, WRONG_TOKEN;
	}
	
	public ExceptionType type;

	public UserException(String message, ExceptionType type) {
		super(message);
		this.message = message;
		this.type = type;
	}
	
	public UserException(String message) {
		super(message);
	}
	

}