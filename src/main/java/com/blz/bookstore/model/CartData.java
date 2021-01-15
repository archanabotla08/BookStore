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
	
	

	public CartData() {
	
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getBookDetails() {
		return bookDetails;
	}

	public void setBookDetails(String bookDetails) {
		this.bookDetails = bookDetails;
	}

	public boolean isInWishList() {
		return isInWishList;
	}

	public void setInWishList(boolean isInWishList) {
		this.isInWishList = isInWishList;
	}

	public UserModel getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserModel userDetails) {
		this.userDetails = userDetails;
	}
	
}
