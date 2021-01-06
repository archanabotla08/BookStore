package com.blz.bookstore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.blz.bookstore.model.CustomerModel;

public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {

    @Query(value = "select * from customer_details where user_id=:userId", nativeQuery = true)
    Optional<CustomerModel> findByUserId(Long userId);
}
