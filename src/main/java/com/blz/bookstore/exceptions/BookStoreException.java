package com.blz.bookstore.exceptions;

public class BookStoreException extends Exception {

	public enum ExceptionType {
		BOOKS_NOT_AVAILABLE, ALREADY_IN_WISHLIST
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
