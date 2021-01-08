package com.blz.bookstore.dto;

import lombok.Data;

@Data
public class BookListDTO {

	public String authorName;
	public String bookDetails;
	public String bookName;
	public String imageURL;
	public double price;
	public Long quantity;

}
