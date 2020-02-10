package com.netent.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netent.bookstore.model.Book;
import com.netent.bookstore.repository.BookRepository;
@Service("bookService")
public class BookServiceImpl implements BookService{
  
	@Autowired
	BookRepository bookRepository;
  
	@Override
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public List<Book> findByAuthorName(String author) {
		
		return bookRepository.findByAuthorLike("%"+author+"%");
	}

	@Override
	public List<Book> findByBookNameLike(String title) {
		
		return bookRepository.findByTitleLike("%"+title+"%");
	}

	@Override
	public List<Book> findByIsbn(String isbn) {

     return bookRepository.findByIsbn(isbn);
	}

}
