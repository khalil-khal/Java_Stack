package com.example.Show.services;




import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Show.models.Book;
import com.example.Show.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public Book retrieveBook(Long id) {
		Optional<Book> book = this.bookRepository.findById(id);
		if(book.isPresent())
			return book.get();
		return null;
		
	}
	
	public void createBook(String title, String description, String language, int numberOfPages) {
		Book book = new Book(title, description, language, numberOfPages);
		this.bookRepository.save(book);
	}
}
