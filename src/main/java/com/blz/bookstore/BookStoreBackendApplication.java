package com.blz.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
//import org.springframework.security.crypto.bcrypt.BCrypt;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@ComponentScan("com.blz.bookstore")
public class BookStoreBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreBackendApplication.class, args);
	}
//	 @Bean
//		@Primary
//		public BCryptPasswordEncoder getpce()
//		{
//			return new BCryptPasswordEncoder();
//		}
//	 public static String hash(String password,int row) {
//	        return BCrypt.hashpw(password, BCrypt.gensalt(row));
//	    }
}
