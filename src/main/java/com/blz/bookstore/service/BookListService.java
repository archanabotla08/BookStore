package com.blz.bookstore.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blz.bookstore.dto.BookListDTO;
import com.blz.bookstore.exceptions.BookStoreException;
import com.blz.bookstore.model.BookListDataModel;
import com.blz.bookstore.repository.BookStoreRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookListService implements IBookListService {

	@Autowired
	private BookStoreRepository bookStoreRepository;

	public List<BookListDataModel> getBookListData() throws BookStoreException {
		List<BookListDataModel> bookList = bookStoreRepository.findAll();
		try {
			if (bookList.isEmpty()) {
				throw new BookStoreException("Books are not available",
						BookStoreException.ExceptionType.BOOKS_NOT_AVAILABLE);
			}
		} catch (BookStoreException e) {
			e.printStackTrace();
		}
		return bookList;
	}

	public BookListDataModel getBookDataByBookId(long bookId) {
		try {
			return bookStoreRepository.findById(bookId)
					.orElseThrow(() -> new BookStoreException("Book with bookId " + bookId + " does not exists!!"));
		} catch (BookStoreException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<BookListDataModel> sortBooksByPriceFromHighToLow() throws BookStoreException {
		List<BookListDataModel> booksList = getBookListData();
		return booksList.stream().sorted((firstBook, secondBook) -> (int) (secondBook.price - firstBook.price))
				.collect(Collectors.toList());
	}

	public List<BookListDataModel> sortBooksByPriceFromLowToHigh() throws BookStoreException {
		List<BookListDataModel> booksList = getBookListData();
		return booksList.stream().sorted((firstBook, secondBook) -> (int) (firstBook.price - secondBook.price))
				.collect(Collectors.toList());
	}

	public BookListDataModel createBookDataIntoList(BookListDTO bookListDTO) throws BookStoreException {
		BookListDataModel bookData = null;
		bookData = new BookListDataModel(bookListDTO);
		log.debug("Book Data: " + bookData.toString());
		return bookStoreRepository.save(bookData);
	}

	public BookListDataModel updateBookDataByBookId(int bookId, BookListDTO bookListDTO) {
		BookListDataModel bookData = this.getBookDataByBookId(bookId);
		bookData.updateBookDataByBookId(bookListDTO);
		return bookStoreRepository.save(bookData);
	}

	public void deleteBookDataByBookId(int bookId) {
		BookListDataModel bookData = this.getBookDataByBookId(bookId);
		bookStoreRepository.delete(bookData);
	}

	public long count() {
		return bookStoreRepository.count();
	}
}
