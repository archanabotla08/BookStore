package com.blz.bookstore.service;

import java.util.List;

import com.blz.bookstore.dto.ResponseDTO;
import com.blz.bookstore.model.CartData;

public class CartService implements ICartService{

	@Override
	public List<CartData> getAllItemFromCart(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CartData> getAllItemFromWishList(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addToCart(String token, Long bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CartData> addMoreItems(Long bookId, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addToWishList(Long bookId, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addFromWishlistToCart(Long bookId, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CartData> removeItem(Long bookId, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAll(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CartData> subtractItem(Long bookId, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CartData> deleteFromWishlist(Long bookId, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
