package com.example.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.mvc.models.Book;
import com.example.mvc.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookrepro;
	 public BookService(BookRepository bookRepository) {
	        this.bookrepro = bookRepository;
	    }
	    // returns all the books
	    public List<Book> allBooks() {
	        return bookrepro.findAll();
	    }
	    // creates a book
	    public Book createBook(Book b) {
	        return bookrepro.save(b);
	    }
	    // retrieves a book
	    public Book findBook(Long id) {
	        Optional<Book> optionalBook = bookrepro.findById(id);
	        if(optionalBook.isPresent()) {
	            return optionalBook.get();
	        } else {
	            return null;
	        }
	    }
	    public Book updateBook(Long id,String title,String desc,String lang,int numOfPages) {
	        	Book book= findBook(id);
	        	book.setTitle(title);
	        	book.setDescription(desc);
	        	book.setLanguage(lang);
	        	book.setNumberOfPages(numOfPages);
	        	bookrepro.save(book);
	        	return book;
	        	
	        	
	        }
	
	    public void deleteBook(Long id) {
	    	bookrepro.deleteById(id);
	    }
}
