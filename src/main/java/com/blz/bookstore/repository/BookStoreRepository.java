package com.blz.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blz.bookstore.model.BookListDataModel;

@Repository
public interface BookStoreRepository extends JpaRepository<BookListDataModel, Integer> {

}
