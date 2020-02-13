package com.netent.bookstore.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.doReturn;
import com.netent.bookstore.model.Book;
import com.netent.bookstore.model.dto.BookDTO;
import com.netent.bookstore.repository.BookRepository;
import com.netent.bookstore.util.ObjectMapperUtils;

import static org.assertj.core.api.Assertions.assertThat;
@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

@Mock
BookRepository bookRepository;

@InjectMocks
BookServiceImpl bookService;

@Mock
private ObjectMapperUtils modelMapper;

@Test
public void testGetByIsbn(){
	Book book = new Book();
	book.setId(1l);
	book.setIsbn("23");
	List<Book> books = new ArrayList<>();
	books.add(book);
	doReturn(books).when(bookRepository).findByIsbn("23");
	List<BookDTO>actualBooks = bookService.findByIsbn("23");
	assertThat(actualBooks).isEqualTo(modelMapper.mapAll(books, BookDTO.class));
	
}

@Test
public void testGetByAuthor(){
	Book book = new Book();
	book.setId(1l);
	book.setIsbn("23");
	book.setAuthor("sandeep");
	List<Book> books = new ArrayList<>();
	books.add(book);
	doReturn(books).when(bookRepository).findByAuthorLike("%san%");
	List<BookDTO>actualBooks = bookService.findByAuthorName("san");
	assertThat(actualBooks).isEqualTo(modelMapper.mapAll(books, BookDTO.class));
	
}

@Test
public void testGetByTitle(){
	Book book = new Book();
	book.setId(1l);
	book.setIsbn("23");
	book.setTitle("spring");
	List<Book> books = new ArrayList<>();
	books.add(book);
	doReturn(books).when(bookRepository).findByTitleLike("%spri%");
	List<BookDTO>actualBooks = bookService.findByTitleName("spri");
	assertThat(actualBooks).isEqualTo(modelMapper.mapAll(books, BookDTO.class));
	
}

@Test
public void testSaveBook(){
	Book book = new Book();
	book.setId(1l);
	book.setIsbn("23");
	book.setTitle("spring");
	bookRepository.save(book);
	assertThat(book.getId()).isNotNull();
}

}
