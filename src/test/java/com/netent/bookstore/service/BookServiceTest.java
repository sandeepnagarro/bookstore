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
import com.netent.bookstore.repository.BookRepository;
import static org.assertj.core.api.Assertions.assertThat;
@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

@Mock
BookRepository bookRepository;

@InjectMocks
BookServiceImpl bookService;

@Test
public void testGetByIsbn(){
	Book book = new Book();
	book.setId(1l);
	book.setIsbn("23");
	List<Book> books = new ArrayList<>();
	books.add(book);
	doReturn(books).when(bookRepository).findByIsbn("23");
	List<Book>actualBooks = bookService.findByIsbn("23");
	assertThat(actualBooks).isEqualTo(books);
	
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
	List<Book>actualBooks = bookService.findByAuthorName("san");
	assertThat(actualBooks).isEqualTo(books);
	
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
	List<Book>actualBooks = bookService.findByTitleName("spri");
	assertThat(actualBooks).isEqualTo(books);
	
}

}
