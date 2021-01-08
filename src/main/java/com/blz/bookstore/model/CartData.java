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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cart_details")
public @Data class CartData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "book_id")
	private Long bookId;

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

	@Column(name = "book_details", columnDefinition = "TEXT")
	private String bookDetails;

	@Column(name = "is_in_wishlist")
	private boolean isInWishList;

	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name = "userId")
	public UserModel userDetails;

	public CartData(BookListDataModel book) {
		this.bookId = book.getBookId();
		this.quantity = (long) 1;
		this.price = book.getPrice();
		this.bookName = book.getBookName();
		this.authorName = book.getAuthorName();
		this.image = book.getImageURL();
		this.bookDetails = book.getBookDetails();
	}
}
