package com.blz.bookstore.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Component;

import com.blz.bookstore.dto.BookListDTO;
import com.blz.bookstore.exceptions.BookStoreException;
import com.blz.bookstore.model.BookListDataModel;

@Component("IBookListService")
public interface IBookListService {

	List<BookListDataModel> getBookListData() throws BookStoreException;

	BookListDataModel getBookDataByBookId(long bookId);

	List<BookListDataModel> sortBooksByPriceFromHighToLow() throws BookStoreException;

	List<BookListDataModel> sortBooksByPriceFromLowToHigh() throws BookStoreException;
	
	BookListDataModel createBookDataIntoList(BookListDTO bookListDTO) throws BookStoreException;

	BookListDataModel updateBookDataByBookId(int bookId, @Valid BookListDTO bookListDTO);

	void deleteBookDataByBookId(int bookId);

	long count();
}
