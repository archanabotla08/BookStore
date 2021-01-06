package com.blz.bookstore.service;

import java.util.List;

import com.blz.bookstore.dto.ResponseDTO;
import com.blz.bookstore.exceptions.BookStoreException;
import com.blz.bookstore.exceptions.CartException;
import com.blz.bookstore.model.CartData;

public interface ICartService {

	List<CartData> getAllItemFromCart(String token);

	List<CartData> getAllItemFromWishList(String token);

	String addToCart(String token, Long bookId) throws BookStoreException;

	List<CartData> addMoreItems(Long bookId, String token);

	ResponseDTO addToWishList(Long bookId, String token) throws BookStoreException;

	ResponseDTO addFromWishlistToCart(Long bookId, String token);

	List<CartData> removeItem(Long bookId, String token) throws CartException;

	String deleteAll(String token);

	List<CartData> subtractItem(Long bookId, String token);

	List<CartData> deleteFromWishlist(Long bookId, String token);

}