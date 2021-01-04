package com.blz.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blz.bookstore.dto.BookListDTO;
import com.blz.bookstore.dto.ResponseDTO;
import com.blz.bookstore.exceptions.BookStoreException;
import com.blz.bookstore.model.BookListDataModel;
import com.blz.bookstore.repository.BookStoreRepository;
import com.blz.bookstore.service.IBookListService;

import io.swagger.annotations.ApiOperation;

@RestController
@Component
@RequestMapping("/bookstoreservice")
public class BookListController {

	@Autowired
	private IBookListService bookListService;

	@ApiOperation("To get all books in booklist")
	@GetMapping("/getBookList")
	public ResponseEntity<ResponseDTO> getBookStoreData() throws BookStoreException {
		List<BookListDataModel> bookListData = null;
		bookListData = bookListService.getBookListData();
		ResponseDTO resDTO = new ResponseDTO("Get Call Success !!!", bookListData);
		return new ResponseEntity<ResponseDTO>(resDTO, HttpStatus.OK);
	}

	@ApiOperation("For sorting the books from high to low by price")
	@GetMapping("/sort/price/descending")
	public ResponseEntity<ResponseDTO> sortBooksByPriceFromHighToLow() throws BookStoreException {
		List<BookListDataModel> bookList = bookListService.sortBooksByPriceFromHighToLow();
		ResponseDTO resDTO = new ResponseDTO("Books returned in descending order by price", bookList);
		return new ResponseEntity<ResponseDTO>(resDTO, HttpStatus.OK);
	}

	@ApiOperation("For sorting the books from low to high by price")
	@GetMapping("/sort/price/ascending")
	public ResponseEntity<ResponseDTO> sortBooksByPriceFromLowToHigh() throws BookStoreException {
		List<BookListDataModel> bookList = bookListService.sortBooksByPriceFromLowToHigh();
		ResponseDTO resDTO = new ResponseDTO("Books returned in ascending order by price", bookList);
		return new ResponseEntity<ResponseDTO>(resDTO, HttpStatus.OK);
	}

	@ApiOperation("For inserting a book into booklist")
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> createBookDataIntoList(@RequestBody BookListDTO bookListDTO)
			throws BookStoreException {
		BookListDataModel bookList = bookListService.createBookDataIntoList(bookListDTO);
		ResponseDTO resDTO = new ResponseDTO("Inserted book data to list Successfully!!", bookList);
		return new ResponseEntity<ResponseDTO>(resDTO, HttpStatus.OK);
	}
}
