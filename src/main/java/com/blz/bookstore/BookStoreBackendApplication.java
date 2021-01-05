package com.blz.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@ComponentScan("com.blz.bookstore")
public class BookStoreBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreBackendApplication.class, args);
	}
	@Configuration
	public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	    @Override
	    public void configure(HttpSecurity http) throws Exception {
	        (http.requestMatchers().antMatchers("/")).anyRequest();
	    }
	}
	 @Bean
		@Primary
		public BCryptPasswordEncoder getpce()
		{
			return new BCryptPasswordEncoder();
		}
	 public static String hash(String password,int row) {
	        return BCrypt.hashpw(password, BCrypt.gensalt(row));
	    }
}
