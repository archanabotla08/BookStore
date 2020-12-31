package com.blz.bookstore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blz.bookstore.model.BookListDataModel;
import com.blz.bookstore.repository.BookStoreRepository;

@Service
public class BookListService implements IBookListService{

	@Autowired
	private BookStoreRepository bookStoreRepository;
	
//	private List<BookListDataModel> bookList = new ArrayList<>();
	
	@Override
	public List<BookListDataModel> getBookListData() {
	return	bookStoreRepository.findAll();
	}

}
