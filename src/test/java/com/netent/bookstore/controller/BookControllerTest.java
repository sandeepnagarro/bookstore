package com.netent.bookstore.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netent.bookstore.model.Book;
import com.netent.bookstore.repository.BookRepository;
import static org.mockito.ArgumentMatchers.any;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@AutoConfigureMockMvc
@SpringBootTest
@RunWith(SpringRunner.class)
public class BookControllerTest {

 @MockBean
 private  BookRepository bookRepository;
	
 ObjectMapper mapper = new ObjectMapper();

 @Autowired
 private MockMvc mockMvc;

@Test
public void testSaveBook() throws Exception {
	
	Book book = new Book();
	book.setTitle("springboot");
	book.setAuthor("sandeep");
	book.setIsbn("3333");
	book.setId(55l);
	when(bookRepository.save(any(Book.class))).thenReturn(book);
	mockMvc.perform(post("/books").content(mapper.writeValueAsString(book))
			.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated()).andExpect(jsonPath("$.title").value("springboot"))
	.andExpect(jsonPath("$.id", is(55)))
	.andExpect(jsonPath("$.id").exists());
}

@Test
public void testGetByIsbn() throws Exception {
	
	Book book = new Book();
	book.setTitle("springboot");
	book.setAuthor("sandeep");
	book.setIsbn("3333");
	book.setId(55l);
	List<Book> books = Arrays.asList(book);
	when(bookRepository.findByIsbn("3333")).thenReturn(books);
	
	mockMvc.perform(get("/books/isbn").param("isbn", "3333")).andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
	.andExpect(jsonPath("$[0].id", is(55)))
	.andExpect(jsonPath("$[0].id").exists());
}

@Test
public void testGetByAuthor() throws Exception {
	
	Book book = new Book();
	book.setTitle("springboot");
	book.setAuthor("sandeep");
	book.setIsbn("3333");
	book.setId(55l);
	List<Book> books = Arrays.asList(book);
	when(bookRepository.findByAuthorLike("%"+"sandeep"+"%")).thenReturn(books);
	
	 mockMvc.perform(get("/books/author").param("author", "sandeep")).andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
	.andExpect(jsonPath("$[0].id", is(55)))
	.andExpect(jsonPath("$[0].id").exists());
}

@Test
public void testGetByTitle() throws Exception {
	
	Book book = new Book();
	book.setTitle("springboot");
	book.setAuthor("sandeep");
	book.setIsbn("3333");
	book.setId(55l);
	List<Book> books = Arrays.asList(book);
	when(bookRepository.findByTitleLike("%"+"springboot"+"%")).thenReturn(books);
	
	mockMvc.perform(get("/books/title").param("title", "springboot")).andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
	.andExpect(jsonPath("$[0].id", is(55)))
	.andExpect(jsonPath("$[0].id").exists());
}

}
