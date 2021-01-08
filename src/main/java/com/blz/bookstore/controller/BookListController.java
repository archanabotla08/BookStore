package com.blz.bookstore.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blz.bookstore.dto.BookListDTO;
import com.blz.bookstore.dto.ResponseDTO;
import com.blz.bookstore.exceptions.BookStoreException;
import com.blz.bookstore.model.BookListDataModel;
import com.blz.bookstore.service.IBookListService;

import io.swagger.annotations.ApiOperation;

@RestController
@Component
@RequestMapping("/bookstoreservice")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class BookListController {

	@Autowired
	private IBookListService bookListService;

	@ApiOperation("To get all books in booklist from database")
	@GetMapping("/getBookList")
	public ResponseEntity<ResponseDTO> getBookStoreData() throws BookStoreException {
		List<BookListDataModel> bookListData = null;
		bookListData = bookListService.getBookListData();
		ResponseDTO resDTO = new ResponseDTO(200, "Retrieved all books from Database!!", bookListData);
		return new ResponseEntity<ResponseDTO>(resDTO, HttpStatus.OK);
	}

	@ApiOperation("To get book by book-id in booklist from database")
	@GetMapping("/getBook/{bookId}")
	public ResponseEntity<ResponseDTO> getBookDataByBookId(@PathVariable("bookId") long bookId)
			throws BookStoreException {
		BookListDataModel bookData = null;
		bookData = bookListService.getBookDataByBookId(bookId);
		ResponseDTO respDTO = new ResponseDTO(200, "Retrieved Book with BookId Successfully!", bookData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@ApiOperation("For sorting the books from high to low by price")
	@GetMapping("/sort/price/descending")
	public ResponseEntity<ResponseDTO> sortBooksByPriceFromHighToLow() throws BookStoreException {
		List<BookListDataModel> bookList = bookListService.sortBooksByPriceFromHighToLow();
		ResponseDTO resDTO = new ResponseDTO(200, "Books returned in descending order by price", bookList);
		return new ResponseEntity<ResponseDTO>(resDTO, HttpStatus.OK);
	}

	@ApiOperation("For sorting the books from low to high by price")
	@GetMapping("/sort/price/ascending")
	public ResponseEntity<ResponseDTO> sortBooksByPriceFromLowToHigh() throws BookStoreException {
		List<BookListDataModel> bookList = bookListService.sortBooksByPriceFromLowToHigh();
		ResponseDTO resDTO = new ResponseDTO(200, "Books returned in ascending order by price", bookList);
		return new ResponseEntity<ResponseDTO>(resDTO, HttpStatus.OK);
	}

	@ApiOperation("For inserting a book into booklist in database")
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> createBookDataIntoList(@RequestBody BookListDTO bookListDTO)
			throws BookStoreException {
		BookListDataModel bookList = bookListService.createBookDataIntoList(bookListDTO);
		ResponseDTO resDTO = new ResponseDTO(200, "Inserted book data to list Successfully!!", bookList);
		return new ResponseEntity<ResponseDTO>(resDTO, HttpStatus.OK);
	}

	@ApiOperation("For updating a book details in database by book-id")
	@PutMapping("/update/{bookId}")
	public ResponseEntity<ResponseDTO> updateBookDataByBookId(@PathVariable("bookId") long bookId,
			@Valid @RequestBody BookListDTO bookListDTO) throws BookStoreException {
		BookListDataModel bookData = null;
		bookData = bookListService.updateBookDataByBookId(bookId, bookListDTO);
		ResponseDTO respDTO = new ResponseDTO(200, "Updated Book Details in Database Successfully", bookData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@ApiOperation("For deleting a book from database by book-id")
	@DeleteMapping("/delete/{bookId}")
	public ResponseEntity<ResponseDTO> deleteBookDataByBookId(@PathVariable("bookId") long bookId) throws BookStoreException {
		bookListService.deleteBookDataByBookId(bookId);
		ResponseDTO respDTO = new ResponseDTO(200, "Deleted Successfully", "Deleted id: " + bookId);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@ApiOperation("For counting number of records in database")
	@GetMapping("/count")
	public ResponseEntity<ResponseDTO> list() {
		long count = bookListService.count();
		ResponseDTO respDTO = new ResponseDTO(200, "Got count of books successfully!!", count);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
}