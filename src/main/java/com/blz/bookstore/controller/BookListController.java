package com.blz.bookstore.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blz.bookstore.dto.ResponseDTO;
import com.blz.bookstore.model.BookListDataModel;
import com.blz.bookstore.repository.BookStoreRepository;
import com.blz.bookstore.service.IBookListService;

@RestController
@Component
@RequestMapping("/bookstoreservice")
public class BookListController {

	@Autowired
	private IBookListService bookListService;
	
	@RequestMapping("/getBookList")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
		List<BookListDataModel> bookListData = null;
		bookListData = bookListService.getBookListData();
		System.out.println("response: " + bookListData);
		ResponseDTO resDTO = new ResponseDTO("Get Call Success !!!", bookListData);
		return new ResponseEntity<ResponseDTO>(resDTO, HttpStatus.OK);
	}

}
