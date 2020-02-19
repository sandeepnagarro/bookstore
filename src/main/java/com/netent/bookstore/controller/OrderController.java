package com.netent.bookstore.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.netent.bookstore.model.dto.OrderDTO;
import com.netent.bookstore.service.OrderService;

@RestController
public class OrderController {
  

  private static final Logger LOGGER= LoggerFactory.getLogger(OrderController.class);
	
  @Autowired
  private OrderService orderService;
  
	@PostMapping("/books/orders")
	public ResponseEntity<OrderDTO> placeOrder(@Valid @RequestBody OrderDTO order){
		LOGGER.debug("Book ordered list {}", order);
		return new ResponseEntity<>(orderService.save(order), HttpStatus.CREATED);
	}
	
}
