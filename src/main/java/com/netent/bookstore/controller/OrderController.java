package com.netent.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.netent.bookstore.model.Order;
import com.netent.bookstore.service.OrderService;

@RestController
public class OrderController {
  
  @Autowired
  private OrderService orderService;
  
	@PostMapping("/books/orders")
	public ResponseEntity<?> placeOrder(@RequestBody Order order){
		
		orderService.save(order);
		
		return new ResponseEntity<>(order, HttpStatus.CREATED);
	}
	
}
