package com.netent.bookstore.model;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String author;
	private Double price;
	private String isbn;

	public Book() {
		super();
	}
	
	

	public Book(Long id, String title, String author, Double price, String isbn) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.isbn = isbn;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


}