package com.blz.bookstore.dto;

import lombok.ToString;

@ToString
public class BookListDTO {
	
	public int bookId;
	public long id;
	public String authorName;
	public String bookDetails;
	public String bookName;
	public String imageURL;
	public double price;
	public int quantity;
	
}
