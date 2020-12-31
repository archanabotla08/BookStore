package com.blz.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.blz.bookstore.model.BookListDataModel;

@Component("IBookListService")
public interface IBookListService {

	List<BookListDataModel> getBookListData();
}
