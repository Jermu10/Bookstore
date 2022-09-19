package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo (BookRepository repository) {
		return (args) -> {
			Book b1 = new Book("Testi", "Testinen", 2010, "tt-11-tt-11", 20.5);
			Book b2 = new Book("Yritys", "Kakkonen", 2010, "yy-22-yy-22", 25.5);
			Book b3 = new Book("Kokeilu", "Kolmonen", 2010, "kk-33-kk-33", 30.5);
			
			repository.save(b1);
			repository.save(b2);
			repository.save(b3);
		};
	}

}
