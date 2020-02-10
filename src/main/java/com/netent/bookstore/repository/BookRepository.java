package com.netent.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netent.bookstore.model.Book;
@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
List<Book> findByAuthorLike(String author);
List<Book> findByTitleLike(String title);
List<Book> findByIsbn(String isbn);
}
