package com.blz.bookstore.dto;

import java.util.Date;

import lombok.ToString;


public @ToString class BookListDTO {

	public int bookId;
	public long id;
	public String authorName;
	public String bookDetails;
	public String bookName;
	public String imageURL;
	public double price;
	public Integer quantity;
	public Date createdDateAndTime;
	
}
