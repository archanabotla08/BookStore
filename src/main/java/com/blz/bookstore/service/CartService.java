//package com.blz.bookstore.service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//
//import com.blz.bookstore.dto.ResponseDTO;
//import com.blz.bookstore.exceptions.BookStoreException;
//import com.blz.bookstore.exceptions.CartException;
//import com.blz.bookstore.model.BookListDataModel;
//import com.blz.bookstore.model.CartData;
//import com.blz.bookstore.model.UserModel;
//import com.blz.bookstore.repository.BookStoreRepository;
//import com.blz.bookstore.repository.CartRepository;
//import com.blz.bookstore.repository.UserRepository;
//import com.blz.utility.JwtGenerator;
//
//public class CartService implements ICartService {
//	
//	@Autowired
//	public UserRepository userRepository;
//	
//	@Autowired
//	private CartRepository cartRepository;
//	
//	@Autowired
//	private BookStoreRepository bookStoreRepository;
//
//	public List<CartData> getAllItemFromCart(String token) {
//		Long id = JwtGenerator.decodeJWT(token);
//		List<CartData> items = cartRepository.findByUserId(id).stream().filter(c -> !c.getIsInWishList()).collect(Collectors.toList());
//	    if (items.isEmpty())
//	    	return new ArrayList<>();
//	    return items;
//	}
//
//	public List<CartData> getAllItemFromWishList(String token) {
//		 Long id = JwtGenerator.decodeJWT(token);
//	        List<CartData> items = cartRepository.findByUserId(id).stream().filter(CartData::isInWishList).collect(Collectors.toList());
//	        if (items.isEmpty())
//	            return new ArrayList<>();
//	        return items;
//	}
//
//	public String addToCart(String token, Long bookId) {
//		 Long userId=JwtGenerator.decodeJWT(token);
//	        BookListDataModel book;
//			try {
//				book = bookStoreRepository.findById(bookId)
//				        .orElseThrow(() -> new BookStoreException("book does not exist", BookStoreException.ExceptionType.BOOKS_NOT_AVAILABLE));
//				CartData cartModel = new CartData(book);
//				Optional<UserModel> user = userRepository.findById(userId);
//		        cartModel.setUserDetails(user.get());
//		        cartRepository.save(cartModel);
//			} catch (BookStoreException e) {
//				e.printStackTrace();
//			}
//	        return  "book added to cart successfully";
//	}
//
//	public List<CartData> addMoreItems(Long bookId, String token) {
//		 Long userId=JwtGenerator.decodeJWT(token);
//	        List<CartData> items = cartRepository.findByUserId(userId);
//	        List<CartData> selectedItems = items.stream().filter(cartItem -> cartItem.getBookId().equals(bookId))
//	                .collect(Collectors.toList());
//	        Optional<BookListDataModel> book1 = bookStoreRepository.findById(bookId);
//	        if(book1.get().getQuantity()<=selectedItems.get(0).getQuantity()){
//	            return cartRepository.findByUserId(userId);
//	        }
//	        for (CartData book:selectedItems) {
//	            book.setQuantity(book.getQuantity()+1);
//	            cartRepository.save(book);
//	        }
//	        return cartRepository.findByUserId(userId);
//	}
//
//	public ResponseDTO addToWishList(Long bookId, String token) {
//		long id = JwtGenerator.decodeJWT(token);
//        CartData cartData = cartRepository.findByUserIdAndBookId(id, bookId);
//        Long cartBook = cartRepository.findDuplicateBookId(bookId);
//        if(cartBook!=bookId) {
//            if (cartData != null && cartData.getIsInWishList()) {
//                return new ResponseDTO(HttpStatus.OK.value(),"Book already present in wishlist");
//            } else if (cartData != null && !cartData.getIsInWishList()) {
//                return new ResponseDTO(HttpStatus.OK.value(), "Book already added to Cart");
//            } else {
//                BookListDataModel book = bookStoreRepository.findById(bookId)
//                        .orElseThrow(() -> new BookStoreException("book does not exist", BookStoreException.ExceptionType.BOOKS_NOT_AVAILABLE));
//                CartData cartModel = new CartData(book);
//                Optional<UserModel> user = userRepository.findById(id);
//                cartModel.setUserDetails(user.get());
//                cartModel.setIsInWishList(true);
//                cartRepository.save(cartModel);
//                return new ResponseDTO(HttpStatus.OK.value(), "Book added to WishList");
//            }
//        }
//        throw new BookStoreException("Book already present in wishlist", BookStoreException.ExceptionType.ALREADY_IN_WISHLIST);
//	}
//
//	public String addFromWishlistToCart(Long bookId, String token) {
//		 long id = JwtGenerator.decodeJWT(token);
//	        CartData cartModel = cartRepository.findByUserIdAndBookId(id, bookId);
//	        if(cartModel.getIsInWishList()){
//	            cartModel.setIsInWishList(false);
//	            cartRepository.save(cartModel);
//	            return new ResponseDTO(HttpStatus.OK.value(), "Successfully added book to cart from wishlist");
//	        }
//	        return new ResponseDTO(HttpStatus.OK.value(), "Already present in cart, ready to checkout");
//	}
//
//	public List<CartData> removeItem(Long bookId, String token) {
//		 Long userId=JwtGenerator.decodeJWT(token);
//	        List<CartData> items = cartRepository.findByUserId(userId);
//	        if(items.isEmpty()){
//	            throw new CartException("book is not removed", CartException.ExceptionType.EMPTY_CART);
//	        }
//	        List<CartData> selectedItems = items.stream().filter(cartItem -> cartItem.getBookId().equals(bookId))
//	                .collect(Collectors.toList());
//	        for (CartData book:selectedItems) {
//	            cartRepository.delete(book);
//	        }
//	        return cartRepository.findByUserId(userId);
//	}
//
//	public String deleteAll(String token) {
//		 Long userId = JwtGenerator.decodeJWT(token);
//	        cartRepository.deleteByUserId(userId);
//	        return "Items removed Successfully";
//	}
//
//	public List<CartData> subtractItem(Long bookId, String token) {
//		 Long userId=JwtGenerator.decodeJWT(token);
//	        List<CartData> items = cartRepository.findByUserId(userId);
//	        List<CartData> selectedItems = items.stream().filter(cartItem -> cartItem.getBookId().equals(bookId))
//	                .collect(Collectors.toList());
//	        if(selectedItems.get(0).getQuantity()==1)
//	        {
//	            cartRepository.delete(selectedItems.get(0));
//	            return cartRepository.findByUserId(userId);
//	        }
//	        for (CartData book:selectedItems) {
//	            book.setQuantity(book.getQuantity()-1);
//	            cartRepository.save(book);
//	        }
//	        return cartRepository.findByUserId(userId);
//	}
//
//	public List<CartData> deleteFromWishlist(Long bookId, String token) {
//		 Long userId = JwtGenerator.decodeJWT(token);
//	        List<CartData> items = cartRepository.findByUserId(userId).stream().filter(CartData::isInWishList).collect(Collectors.toList());
//	        List<CartData> selectedItems = items.stream().filter(cartItem -> cartItem.getBookId().equals(bookId))
//	                .collect(Collectors.toList());
//	        for (CartData book : selectedItems) {
//	            cartRepository.delete(book);
//	        }
//	        return cartRepository.findByUserId(userId);
//	}
//}
