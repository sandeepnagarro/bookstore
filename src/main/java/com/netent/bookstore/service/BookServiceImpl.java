package com.netent.bookstore.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.netent.bookstore.model.Book;
import com.netent.bookstore.model.dto.BookDTO;
import com.netent.bookstore.repository.BookRepository;
import com.netent.bookstore.util.ObjectMapperUtils;
@Service("bookService")
public class BookServiceImpl implements BookService{
  
	@Autowired
	BookRepository bookRepository;
  
	@Autowired
	private ObjectMapperUtils modelMapper;
	
	@Override
	@Transactional
	public BookDTO saveBook(BookDTO book) {
		
		return modelMapper.map(bookRepository.save(convertToBook(book)), BookDTO.class);
	}

	@Override
	public List<BookDTO> findByAuthorName(String author) {
		
		return modelMapper.mapAll(bookRepository.findByAuthorLike("%"+author+"%"), BookDTO.class);
	}

	@Override
	public List<BookDTO> findByTitleName(String title) {
		
		return modelMapper.mapAll(bookRepository.findByTitleLike("%"+title+"%"), BookDTO.class);
	}

	@Override
	public List<BookDTO> findByIsbn(String isbn) {
		
		return modelMapper.mapAll(bookRepository.findByIsbn(isbn), BookDTO.class);
	}

	private Book convertToBook(BookDTO order) {
		   return modelMapper.map(order, Book.class);
		  }
	
}
