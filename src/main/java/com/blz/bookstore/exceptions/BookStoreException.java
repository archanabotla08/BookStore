package com.blz.bookstore.exceptions;

public class BookStoreException extends Exception {

	private String message;
	public ExceptionType type;

	public enum ExceptionType {
		BOOKS_NOT_AVAILABLE, ALREADY_IN_WISHLIST
	}

	public BookStoreException(String message, ExceptionType exceptionType) {
		super(message);
		this.type = exceptionType;
	}

	public BookStoreException(String message) {
		super(message);
	}
}
