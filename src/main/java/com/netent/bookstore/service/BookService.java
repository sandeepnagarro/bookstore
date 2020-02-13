package com.netent.bookstore.service;

import java.util.List;
import com.netent.bookstore.model.dto.BookDTO;

public interface BookService {
BookDTO saveBook(BookDTO book);
List<BookDTO> findByAuthorName(String author);
List<BookDTO> findByTitleName(String title);
List<BookDTO> findByIsbn(String isbn);
}
