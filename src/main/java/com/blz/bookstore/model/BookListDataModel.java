package com.blz.bookstore.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.blz.bookstore.dto.BookListDTO;

import lombok.Data;

@Entity
@Table(name = "booklistDetails")
public @Data class BookListDataModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private Long bookId;

	@Column(name = "author_name")
	private String authorName;

	@Column(name = "book_details", columnDefinition = "TEXT")
	private String bookDetails;

	@Column(name = "book_name")
	private String bookName;

	@Column(name = "image")
	private String imageURL;

	@Column(name = "price")
	public Double price;

	@Column(name = "quantity")
	private Long quantity;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date_and_time")
	public Date createdDateAndTime;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date_and_time")
	private Date updatedDateAndTime;

	public BookListDataModel() {
	}

	public BookListDataModel(BookListDTO bookListDTO) {
		this.updateBookDataByBookId(bookListDTO);
	}

	public void updateBookDataByBookId(BookListDTO bookListDTO) {
		this.authorName = bookListDTO.authorName;
		this.bookDetails = bookListDTO.bookDetails;
		this.bookName = bookListDTO.bookName;
		this.imageURL = bookListDTO.imageURL;
		this.price = bookListDTO.price;
		this.quantity = bookListDTO.quantity;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getBookDetails() {
		return bookDetails;
	}

	public void setBookDetails(String bookDetails) {
		this.bookDetails = bookDetails;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Date getCreatedDateAndTime() {
		return createdDateAndTime;
	}

	public void setCreatedDateAndTime(Date createdDateAndTime) {
		this.createdDateAndTime = createdDateAndTime;
	}

	public Date getUpdatedDateAndTime() {
		return updatedDateAndTime;
	}

	public void setUpdatedDateAndTime(Date updatedDateAndTime) {
		this.updatedDateAndTime = updatedDateAndTime;
	}
}
