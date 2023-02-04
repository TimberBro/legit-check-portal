package ru.epopov.legitcheck.webapi.services.springdatajpa;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import ru.epopov.legitcheck.webapi.model.Order;
import ru.epopov.legitcheck.webapi.repositories.OrderRepository;
import ru.epopov.legitcheck.webapi.services.OrderService;

class OrderServiceImplTest {

  OrderService orderService;

  @Mock
  OrderRepository orderRepository;

  public OrderServiceImplTest() {
    MockitoAnnotations.openMocks(this);
    orderService = new OrderServiceImpl(orderRepository);
  }

  @BeforeEach
  void setUp() {
  }

  @Test
  void findById() {
    // given
    Order order = new Order();
    order.setId(14);

    // when
    when(orderRepository.findById(anyInt())).thenReturn(Optional.of(order));

    Order foundOrder = orderService.findById(14);
    Assertions.assertNotNull(foundOrder);
    verify(orderRepository, times(1)).findById(anyInt());
  }
}