package com.blz.bookstore.exceptions;

public class BookStoreException extends RuntimeException {

	
	public enum ExceptionType {
		BOOKS_NOT_AVAILABLE
	}

	public ExceptionType type;

	public BookStoreException(String message, ExceptionType exceptionType) {
		super(message);
		this.type = exceptionType;
	}

	public BookStoreException(String message) {
		super(message);
	}
}
