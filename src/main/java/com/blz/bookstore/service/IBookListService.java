package com.blz.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.blz.bookstore.dto.BookListDTO;
import com.blz.bookstore.exceptions.BookStoreException;
import com.blz.bookstore.model.BookListDataModel;

@Component("IBookListService")
public interface IBookListService {

	List<BookListDataModel> getBookListData() throws BookStoreException;
	
	List<BookListDataModel> sortBooksByPriceFromHighToLow() throws BookStoreException;

	List<BookListDataModel> sortBooksByPriceFromLowToHigh() throws BookStoreException;

	BookListDataModel createBookDataIntoList(BookListDTO bookListDTO) throws BookStoreException;
}
