package com.netent.bookstore.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.netent.bookstore.model.Book;
import com.netent.bookstore.model.UserInfo;
import com.netent.bookstore.service.BookService;

@RestController
public class BookStoreController {

	@Autowired
	BookService bookService;
	@PostMapping("/books")
	public ResponseEntity<?> book(@RequestBody Book book){
		bookService.saveBook(book);
		
		return new ResponseEntity<>(book, HttpStatus.CREATED);
	}
	
	@GetMapping("/books/isbn")
	public ResponseEntity<List<Book>> getByIsbn(@RequestParam String isbn){
		List<Book> books = new ArrayList<Book>();
		books =  bookService.findByIsbn(isbn);
		if(books.isEmpty()){
			return new ResponseEntity<>(books, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(books, HttpStatus.OK);
	}
	
	@GetMapping("/books/author")
	public ResponseEntity<List<Book>> getByAuthorName(@RequestParam String author){
					List<Book> books = new ArrayList<Book>();
					books =  bookService.findByAuthorName(author);
					if(books.isEmpty()){
						return new ResponseEntity<>(books, HttpStatus.NOT_FOUND);
					}
					return new ResponseEntity<>(books, HttpStatus.OK);
	}
	
	
	@GetMapping("/books/title")
	public ResponseEntity<List<Book>> getByTitle(@RequestParam String title){
		List<Book> books = new ArrayList<Book>();
		
		books = bookService.findByTitleName(title);
		if(books.isEmpty()){
			return new ResponseEntity<>(books, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(books, HttpStatus.OK);
		
	}
	
	@GetMapping("/books/media/serach")
	public List<String> searchMediaCovrageMatchTitle(@RequestParam String title){
		List<String>matchedList = new ArrayList<>();
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<UserInfo>> usersResponse =
		        restTemplate.exchange("https://jsonplaceholder.typicode.com/posts",
		                    HttpMethod.GET, null, new ParameterizedTypeReference<List<UserInfo>>() {
		            });
		List<UserInfo> usersList = usersResponse.getBody();
		for(UserInfo user : usersList){
			if(user.getTitle().contains(title)|| user.getBody().contains(title)){
				matchedList.add(user.getTitle());
			}
		}
		return matchedList;
	}
}
