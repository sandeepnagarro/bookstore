package com.netent.bookstore.util;

import java.util.Arrays;

import com.netent.bookstore.model.Book;
import com.netent.bookstore.model.Order;
import com.netent.bookstore.model.OrderLine;

public class DataBuilder {

    public static Order buildOrder() {

        Book book = buildBook();

        return buildOrder(book);
    }

    public static Order buildOrder(Book book) {
        OrderLine orderLine = new OrderLine();
        orderLine.setBook(book);
        orderLine.setQuantity(Integer.valueOf(1));

        Order order = new Order();
        order.setOrderLines(Arrays.asList(orderLine));
        order.setName("Olivier");
        order.setAddress("France");
        return order;
    }

    public static Book buildBook() {

        Book book = new Book();
        book.setAuthor("Chris Schaefer , Clarence Ho , Rob Harrop");
        book.setTitle("Pro Spring");
        book.setIsbn("345");
        book.setPrice(23.00);
        return book;
    }
}