package com.blz.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blz.bookstore.dto.ResponseDTO;
import com.blz.bookstore.exceptions.BookStoreException;
import com.blz.bookstore.exceptions.CartException;
import com.blz.bookstore.exceptions.UserException;
import com.blz.bookstore.model.CartData;
import com.blz.bookstore.service.ICartService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/cart")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class CartController {

	@Autowired
	private ICartService cartService;

	@ApiOperation(value = "For getting all books in the cart")
	@GetMapping("/allbooks")
	public ResponseEntity<ResponseDTO> getAllItemsFromCart(@RequestHeader String token)
			throws CartException, UserException {
		List<CartData> userCart = cartService.getAllItemFromCart(token);
		ResponseDTO respDTO = new ResponseDTO(200, "Successfully returned books from cart", userCart);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@ApiOperation(value = "For getting all books from wishlist")
	@GetMapping("/wishlist/all")
	public ResponseEntity<ResponseDTO> getWishListBooks(@RequestHeader("token") String token)
			throws BookStoreException, UserException {
		List<CartData> cartData = cartService.getAllItemFromWishList(token);
		ResponseDTO resDTO = new ResponseDTO(200, "Retrieved all books from WishList!!", cartData);
		return new ResponseEntity<ResponseDTO>(resDTO, HttpStatus.OK);
	}

	@ApiOperation(value = "For adding the book to cart")
	@PostMapping("/book")
	public ResponseEntity<ResponseDTO> addToCart(@RequestParam Long bookId, @RequestHeader String token)
			throws UserException, BookStoreException {
		String responseMessage = cartService.addToCart(token, bookId);
		ResponseDTO respDTO = new ResponseDTO(200, "Successfully added book to cart", responseMessage);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@ApiOperation(value = "For incrementing book quantity")
	@PostMapping("/moreitems")
	public ResponseEntity<ResponseDTO> addMoreItems(@RequestParam Long bookId, @RequestHeader String token)
			throws BookStoreException, UserException {
		List<CartData> userCart = cartService.addMoreItems(bookId, token);
		ResponseDTO respDTO = new ResponseDTO(200, "Successfully incremented book quantity", userCart);
		return new ResponseEntity<>(respDTO, HttpStatus.OK);
	}

	@ApiOperation(value = "For adding book to wishlist")
	@PostMapping("/wishlist/book")
	public ResponseEntity<ResponseDTO> addToWishList(@RequestParam Long bookId, @RequestHeader("token") String token)
			throws BookStoreException, UserException {
		String responseMessage =  cartService.addToWishList(bookId, token);
		ResponseDTO respDTO = new ResponseDTO(200, "Successfully added book to wishlist", responseMessage);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@ApiOperation(value = "For putting books wishlist to cart")
	@PutMapping("/wishlist/to/cart")
	public ResponseDTO addFromWishlistToCart(@RequestParam Long bookId, @RequestHeader("token") String token)
			throws UserException {
		return cartService.addFromWishlistToCart(bookId, token);
	}

	@ApiOperation(value = "For removing book from the cart")
	@DeleteMapping("/book")
	public ResponseEntity<ResponseDTO> removeFromCart(@RequestParam Long bookId, @RequestHeader String token)
			throws BookStoreException, CartException, UserException {
		List<CartData> userCart = cartService.removeItem(bookId, token);
		return new ResponseEntity<>(new ResponseDTO(200, "Successfully removed book from cart", userCart),
				HttpStatus.OK);
	}

	@ApiOperation(value = "For removing entire Cart")
	@DeleteMapping("/all")
	public ResponseEntity<ResponseDTO> removeAllItem(@RequestHeader String token) throws CartException, UserException {
		String responseMessage = cartService.deleteAll(token);
		return new ResponseEntity<>(new ResponseDTO(200, responseMessage), HttpStatus.OK);
	}

	@ApiOperation(value = "For decrementing the book quantity")
	@DeleteMapping("/item")
	public ResponseEntity<ResponseDTO> subtractItem(@RequestParam Long bookId, @RequestHeader String token)
			throws UserException {
		List<CartData> carts = cartService.subtractItem(bookId, token);
		return new ResponseEntity<>(new ResponseDTO(200, "Book quantity decremented successfully", carts),
				HttpStatus.OK);
	}

	@ApiOperation(value = "For deleting book from wishlist")
	@DeleteMapping("/Wishlist/book")
	public ResponseEntity<ResponseDTO> deleteFromWishlist(@RequestParam Long bookId,
			@RequestHeader("token") String token) throws UserException {
		List<CartData> cart = cartService.deleteFromWishlist(bookId, token);
		return new ResponseEntity<>(new ResponseDTO(200, "Book removed from wishlist", cart), HttpStatus.OK);
	}
}
