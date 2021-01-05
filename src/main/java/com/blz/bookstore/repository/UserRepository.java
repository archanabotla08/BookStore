package com.blz.bookstore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.blz.bookstore.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>{

	@Query(value="SELECT * FROM user where email_id=:emailId",nativeQuery=true)
	Optional<UserModel> findByEmailId(String emailId);
	
}
