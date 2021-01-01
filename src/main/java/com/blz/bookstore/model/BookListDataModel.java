package com.blz.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="booklistDetails")
public class BookListDataModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "book_id")
	Integer bookId;
	
	@Column(name="_id")
	Long id;
	
	@Column(name="author_name")
	String authorName;
	
	@Column(name="book_details")
	String bookDetails;
	
	@Column(name="book_name")
	String bookName;


	@Column(name="image")
	String imageURL;
	
	@Column(name="price")
	Double price;
	
	@Column(name="quantity")
	Integer quantity;
	
}
