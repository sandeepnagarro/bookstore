package com.netent.bookstore.exception;

public class BookNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public BookNotFoundException(String errorMessage) {
		 this.errorMessage = errorMessage;
	}
	
	 public String getErrorMessage() {
	        return errorMessage;
	    }
}
