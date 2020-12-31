package com.blz.bookstore.dto;

import lombok.ToString;

public @ToString class BookListDTO {
	
	public String id;
	public String authorName;
	public String bookDetails;
	public String bookName;
	public String imageURL;
	public double price;
	public int quantity;
}
