package com.netent.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.netent.bookstore.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
