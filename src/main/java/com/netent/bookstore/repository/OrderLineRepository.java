package com.netent.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.netent.bookstore.model.OrderLine;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long>{
	
}
