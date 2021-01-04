package com.blz.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.blz.bookstore.dto.BookListDTO;

import lombok.Data;

@Entity
@Table(name="booklistDetails")
public @Data class BookListDataModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "book_id")
	public Integer bookId;
	
	@Column(name="_id")
	public Long id;
	
	@Column(name="author_name")
	public String authorName;
	
	@Column(name="book_details")
	public String bookDetails;
	
	@Column(name="book_name")
	public String bookName;
	
	@Column(name="image")
	public String imageURL;
	
	@Column(name="price")
	public Double price;
	
	@Column(name="quantity")
	public Integer quantity;

	
	public BookListDataModel() {}
	
	public BookListDataModel(BookListDTO bookListDTO) {
		this.bookId = bookListDTO.bookId;
		this.id = bookListDTO.id;
		this.authorName = bookListDTO.authorName;
		this.bookDetails = bookListDTO.bookDetails;
		this.bookName = bookListDTO.bookName;
		this.imageURL = bookListDTO.imageURL;
		this.price = bookListDTO.price;
		this.quantity = bookListDTO.quantity;
	}
}
