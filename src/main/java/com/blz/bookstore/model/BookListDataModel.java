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
}
