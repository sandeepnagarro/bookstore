package com.netent.bookstore.util;

import java.util.Arrays;

import com.netent.bookstore.model.Book;
import com.netent.bookstore.model.Order;
import com.netent.bookstore.model.OrderLine;
import com.netent.bookstore.model.dto.BookDTO;
import com.netent.bookstore.model.dto.OrderDTO;
import com.netent.bookstore.model.dto.OrderLineDTO;

public class DataBuilder {

    public static OrderDTO buildOrder() {

        BookDTO book = buildBook();

        return buildOrder(book);
    }

    public static OrderDTO buildOrder(BookDTO book) {
        OrderLineDTO orderLine = new OrderLineDTO();
        orderLine.setBookDto(book);
        orderLine.setQuantity(Integer.valueOf(1));

        OrderDTO order = new OrderDTO();
        order.setOrderLines(Arrays.asList(orderLine));
        order.setName("Olivier");
        order.setAddress("France");
        return order;
    }

    public static BookDTO buildBook() {

        BookDTO book = new BookDTO();
        book.setAuthor("Chris Schaefer , Clarence Ho , Rob Harrop");
        book.setTitle("Pro Spring");
        book.setIsbn("345");
        book.setPrice(23.00);
        return book;
    }
}