package com.blz.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.blz.bookstore")
public class BookStoreBackendApplication {

	public static void main(String[] args) {
		System.out.println("Welcome to BookStore Backend");
		SpringApplication.run(BookStoreBackendApplication.class, args);
	}
}
