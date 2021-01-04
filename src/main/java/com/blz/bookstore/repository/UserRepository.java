package com.blz.bookstore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.blz.bookstore.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer>{

	@Query(value="SELECT * FROM user where email_id=:emailId",nativeQuery=true)
	Optional<UserModel> findByEmailId(String emailId);

	Optional<UserModel> findById(Long userId);
	
}
