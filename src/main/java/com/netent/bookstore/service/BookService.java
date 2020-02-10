package com.netent.bookstore.service;

import java.util.List;

import com.netent.bookstore.model.Book;

public interface BookService {
Book saveBook(Book book);
List<Book> findByAuthorName(String author);
List<Book> findByTitleName(String title);
List<Book> findByIsbn(String isbn);
}
