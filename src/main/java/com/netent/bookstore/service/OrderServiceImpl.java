package com.netent.bookstore.service;

import java.util.Date;
import java.util.Optional;
import javax.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.netent.bookstore.exception.RecordNotFoundException;
import com.netent.bookstore.model.Book;
import com.netent.bookstore.model.Order;
import com.netent.bookstore.model.dto.BookDTO;
import com.netent.bookstore.model.dto.OrderDTO;
import com.netent.bookstore.model.dto.OrderLineDTO;
import com.netent.bookstore.repository.BookRepository;
import com.netent.bookstore.repository.OrderRepository;
import com.netent.bookstore.util.ObjectMapperUtils;
@Service("orderService")
public class OrderServiceImpl implements OrderService{

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ObjectMapperUtils modelMapper;
	
	ModelMapper mp = new ModelMapper();
	
	@Override
	@Transactional
	public OrderDTO save(OrderDTO orderDto) {
		int countValidBooks = 0;
		orderDto.setCreationDate(new Date());
		for(OrderLineDTO orderLine : orderDto.getOrderLines()){
			Optional<Book> bookOptional = bookRepository.findById(orderLine.getBookDto().getId());
			if(bookOptional.isPresent()){
				Integer availableBooks = bookOptional.get().getBookCounter() - orderLine.getBookDto().getBookCounter();
				if(availableBooks>0) {
				bookOptional.get().setBookCounter(availableBooks);
				orderLine.setBookDto(modelMapper.map(bookOptional.get(), BookDTO.class));
				countValidBooks++;
				}
				else {
					throw new RecordNotFoundException("only "+ bookOptional.get().getBookCounter()+ " books available in stock");
				}
			}
		}
		if(countValidBooks<1){
			throw new RecordNotFoundException("Books are not valid");
		}
		return modelMapper.map(orderRepository.save(convertToOrder(orderDto)), OrderDTO.class);
	}
	private Order convertToOrder(OrderDTO order) {
		   return mp.map(order, Order.class);
		  }
}
