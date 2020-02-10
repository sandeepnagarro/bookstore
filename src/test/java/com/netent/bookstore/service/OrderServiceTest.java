package com.netent.bookstore.service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;
import com.netent.bookstore.model.Book;
import com.netent.bookstore.model.Order;
import com.netent.bookstore.repository.BookRepository;
import com.netent.bookstore.repository.OrderLineRepository;
import com.netent.bookstore.repository.OrderRepository;
import com.netent.bookstore.util.DataBuilder;
import java.util.Date;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

    @Mock
    BookRepository mockBookRepository;

    @Mock
    OrderRepository mockOrderRepository;

    @Mock
    OrderLineRepository mockOrderLineRepository;

    @Test
    public void save() {

        //GIVEN
        Date beginDate = new Date();

        Book book = DataBuilder.buildBook();

        final Long bookId = Long.valueOf(123l);
        book.setId(bookId);
        Order order = DataBuilder.buildOrder(book);
        assertThat(order.getCreationDate()).as("Order ID").isNull();
        when(mockBookRepository.findById(isA(Long.class))).thenReturn(Optional.empty());

        OrderService orderService = new OrderServiceImpl();

        ReflectionTestUtils.setField(orderService, "bookRepository", mockBookRepository);
        ReflectionTestUtils.setField(orderService, "orderRepository", mockOrderRepository);
        ReflectionTestUtils.setField(orderService, "orderLineRepository", mockOrderLineRepository);


        //WHEN
        orderService.save(order);

        //THEN
        verify(mockBookRepository).findById(eq(bookId));
        verify(mockOrderLineRepository).save(eq(order.getOrderLines().get(0)));
        verify(mockOrderRepository).save(eq(order));

        assertThat(order.getCreationDate()).isAfterOrEqualsTo(beginDate);
    }


}
