package com.netent.bookstore.service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.ReflectionTestUtils;
import com.netent.bookstore.model.Book;
import com.netent.bookstore.model.Order;
import com.netent.bookstore.model.dto.BookDTO;
import com.netent.bookstore.model.dto.OrderDTO;
import com.netent.bookstore.repository.BookRepository;
import com.netent.bookstore.repository.OrderLineRepository;
import com.netent.bookstore.repository.OrderRepository;
import com.netent.bookstore.util.DataBuilder;
import com.netent.bookstore.util.ObjectMapperUtils;
import java.util.Date;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

    @Mock
    BookRepository mockBookRepository;

    @Mock
    OrderRepository mockOrderRepository;
    
    @Mock
	private ObjectMapperUtils mockModelMapper;
    
    ModelMapper mp = new ModelMapper();

    @Test
    public void save() {

        //GIVEN
        Date beginDate = new Date();

        BookDTO book = DataBuilder.buildBook();

        final Long bookId = Long.valueOf(123l);
        book.setId(bookId);
        OrderDTO order = DataBuilder.buildOrder(book);
        assertThat(order.getCreationDate()).as("Order ID").isNull();
        when(mockBookRepository.findById(123l)).thenReturn(Optional.of(mp.map(book, Book.class)));

        OrderService orderService = new OrderServiceImpl();

        ReflectionTestUtils.setField(orderService, "bookRepository", mockBookRepository);
        ReflectionTestUtils.setField(orderService, "orderRepository", mockOrderRepository);
        ReflectionTestUtils.setField(orderService, "modelMapper", mockModelMapper);
        //WHEN
        orderService.save(order);

        //THEN
        verify(mockBookRepository).findById(eq(bookId));

        assertThat(order.getCreationDate()).isAfterOrEqualsTo(beginDate);
    }


}
