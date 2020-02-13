package com.netent.bookstore.model.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class BookDTO  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long id;
	@NotEmpty(message = "title must not be empty")
	private String title;
	private String author;
	private Double price;
	private String isbn;
	
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
