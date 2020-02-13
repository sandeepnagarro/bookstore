package com.netent.bookstore.model.dto;

import java.io.Serializable;
public class OrderLineDTO implements Serializable{
	  
	 private static final long serialVersionUID = 1L;
	
    private Long id;
  
    private Integer quantity;

    private BookDTO bookDto;

	
	public BookDTO getBookDto() {
		return bookDto;
	}

	public void setBookDto(BookDTO bookDto) {
		this.bookDto = bookDto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	
}
