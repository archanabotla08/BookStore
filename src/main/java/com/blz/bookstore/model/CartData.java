package com.blz.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "cart_details")
public @Data class CartData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "book_id")
	private Integer bookId;
	
	@Column(name = "quantity")
	private Long quantity;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "book_name")
	private String bookName;
	
	@Column(name = "author_name")
	private String authorName;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "book_details")
	private String bookDetails;
	
	@Column(name = "is_in_wishlist")
	private Boolean isInWishList;
	
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name = "userId")
	@Column(name = "user_details")
	public UserData userDetails;
	
	public CartData(BookListDataModel book) {
		this.bookId = book.getBookId();
		this.quantity = (long) 1;
		this.price = book.getPrice();
		this.bookName = book.getBookName();
		this.authorName = book.getAuthorName();
		this.image = book.getImageURL();
		this.bookDetails = this.getBookDetails();
	}
	
	public CartData(long id, int bookId, long quantity, double price, String bookName, 
			String authorName, String image, String bookDetails, UserData userDetails, Boolean isInWishList) {
		this.id = id;
		this.bookId = bookId;
		this.quantity = quantity;
		this.price = price;
		this.bookName = bookName;
		this.authorName = authorName;
		this.image = image;
		this.bookDetails = bookDetails;
		this.userDetails = userDetails;
		this.isInWishList = isInWishList;
	}
	
}
