package com.blz.bookstore.exceptions;

public class EmailSendingException extends RuntimeException {

	private final int status;
	
	public EmailSendingException(String message, int status) {
		super(message);
		this.status = status;
	}
}
