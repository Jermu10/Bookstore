package com.example.Bookstore;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;



import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BookRepositoryTest {
	
	@Autowired
	private BookRepository repository;
	
	@Test
	public void deleteBook() {
		List<Book> books = repository.findByTitle("Testi");
		Book book = books.get(0);
		repository.delete(book);
		
		assertThat(book.getId()).isNull();
	}
	
}

