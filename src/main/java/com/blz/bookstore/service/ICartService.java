package com.blz.bookstore.service;

import java.util.List;

import com.blz.bookstore.dto.ResponseDTO;
import com.blz.bookstore.exceptions.BookStoreException;
import com.blz.bookstore.exceptions.CartException;
import com.blz.bookstore.exceptions.UserException;
import com.blz.bookstore.model.CartData;

public interface ICartService {

	List<CartData> getAllItemFromCart(String token) throws UserException;

	List<CartData> getAllItemFromWishList(String token) throws UserException;

	String addToCart(String token, Long bookId) throws BookStoreException, UserException;

	List<CartData> addMoreItems(Long bookId, String token) throws UserException;

	String addToWishList(Long bookId, String token) throws BookStoreException, UserException;

	ResponseDTO addFromWishlistToCart(Long bookId, String token) throws UserException;

	List<CartData> removeItem(Long bookId, String token) throws CartException, UserException;

	String deleteAll(String token) throws UserException;

	List<CartData> subtractItem(Long bookId, String token) throws UserException;

	List<CartData> deleteFromWishlist(Long bookId, String token) throws UserException;

}