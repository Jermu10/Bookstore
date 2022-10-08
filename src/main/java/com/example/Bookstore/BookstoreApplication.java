package com.example.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;
import com.example.Bookstore.domain.User;
import com.example.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo (BookRepository brepository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			
			// Adding categories
			crepository.save(new Category("Scifi"));
			crepository.save(new Category("Drama"));
			crepository.save(new Category("Comedy"));
			
			// Adding books
			brepository.save(new Book("Testi", "Testinen", 2010, "tt-11-tt-11", 20.5, crepository.findByName("Scifi").get(0)));
			brepository.save(new Book("Yritys", "Kakkonen", 2010, "yy-22-yy-22", 25.5, crepository.findByName("Drama").get(0)));
			brepository.save(new Book("Kokeilu", "Kolmonen", 2010, "kk-33-kk-33", 30.5, crepository.findByName("Comedy").get(0)));
			
			// Adding users
			urepository.save(new User("user", "$2a$10$DEnkf9y4Vec3qxHinw841OYnVEzrBPr7eePph.7wwOtcqlcq/vrhG", "user@user.com", "USER"));
			urepository.save(new User("admin", "$2a$10$TLfHPGgw8GYcWu7gJYNhtefYozWMQvKsnSKmIJcch5dErJEUoQ51O", "admin@admin.com", "ADMIN"));
			
			
			// For eclipse console
			log.info("fetch all categories");
			for (Category category : crepository.findAll()) {

				log.info(category.toString());
			}

			log.info("fetch all books");
			for (Book book : brepository.findAll()) {

				log.info(book.toString());
			} 
		};
		
		
	}

}
