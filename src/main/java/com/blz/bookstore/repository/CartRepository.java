package com.blz.bookstore.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.blz.bookstore.model.CartData;

@Repository
public interface CartRepository extends JpaRepository<CartData, Long> {

	@Query(value = "SELECT * FROM cart_details WHERE user_id=:userId", nativeQuery = true)
	List<CartData> findUserById(Long userId);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM cart_details WHERE user_id=:userId", nativeQuery = true)
	void deleteByUserId(Long userId);

	@Query(value = "SELECT book_id FROM cart_details WHERE book_id=?", nativeQuery = true)
	Long findDuplicateBookId(Long bookId);

	@Query(value = "SELECT * FROM cart_details WHERE user_id=:id AND book_id=:bookId", nativeQuery = true)
	CartData findByUserIdAndBookId(long id, long bookId);
}
