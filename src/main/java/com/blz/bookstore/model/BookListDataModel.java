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
	private int bookId;
	
	@Column(name="_id")
	private String id;

	@Column(name="author_name")
	private String authorName;
	
	@Column(name="book_details")
	private String bookDetails;
	
	@Column(name="book_name")
	private String bookName;
	
	@Column(name="image")
	private String imageURL;
	
	@Column(name="price")
	public Double price;
	
	@Column(name="quantity")
	private int quantity;
	
	public BookListDataModel() {}
	
	public BookListDataModel(BookListDTO bookListDTO) {
		this.updateBookDataByBookId(bookListDTO);
	}
	
	public void updateBookDataByBookId(BookListDTO bookListDTO) {
		this.id = bookListDTO.id;
		this.authorName = bookListDTO.authorName;
		this.bookDetails = bookListDTO.bookDetails;
		this.bookName = bookListDTO.bookName;
		this.imageURL = bookListDTO.imageURL;
		this.price = bookListDTO.price;
		this.quantity = bookListDTO.quantity;
	}
}
