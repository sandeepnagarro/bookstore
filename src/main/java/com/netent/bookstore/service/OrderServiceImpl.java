package com.netent.bookstore.service;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netent.bookstore.model.Order;
import com.netent.bookstore.model.OrderLine;
import com.netent.bookstore.repository.BookRepository;
import com.netent.bookstore.repository.OrderLineRepository;
import com.netent.bookstore.repository.OrderRepository;
@Service("orderService")
public class OrderServiceImpl implements OrderService{

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private OrderLineRepository orderLineRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void save(Order order) {
		order.setCreationDate(new Date());
		for(OrderLine orderLine : order.getOrderLines()){
			bookRepository.findById(orderLine.getBook().getId()).ifPresent(orderLine :: setBook);
			orderLineRepository.save(orderLine);
		}
		orderRepository.save(order);
	}

}
