package com.blz.bookstore.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.blz.bookstore.model.OrderData;

@Repository
public interface OrderRepository extends JpaRepository<OrderData, Long> {

	@Query(value = "SELECT * FROM order_details WHERE user=:userId", nativeQuery = true)
	Optional<OrderData> findByUserId(Long userId);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM order_details WHERE user=:userId", nativeQuery = true)
	void deleteByUserId(Long userId);
	
//	@Query(value = "SELECT * FROM order_details WHERE user=:userId", nativeQuery = true)
//	Optional<OrderData> findByUserId(Long userId);
}

