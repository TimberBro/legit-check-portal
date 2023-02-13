package ru.epopov.legitcheck.webapi.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import ru.epopov.legitcheck.webapi.model.Order;
import ru.epopov.legitcheck.webapi.repositories.OrderRepository;
import ru.epopov.legitcheck.webapi.services.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

  private final OrderRepository orderRepository;

  public OrderServiceImpl(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  @Override
  public Order findById(Integer integer) {
    return orderRepository
        .findById(integer)
        .orElseThrow(
            () -> new EntityNotFoundException("Order with id=" + integer + " was not found."));
  }

  @Override
  public Order save(Order object) {
    return orderRepository.save(object);
  }

  @Override
  public Set<Order> findAll() {
    Set<Order> orders = new HashSet<>();
    for (Order order : orderRepository.findAll()) {
      orders.add(order);
    }
    return orders;
  }

  @Override
  public void delete(Order object) {
    orderRepository.delete(object);
  }

  @Override
  public void deleteById(Integer integer) {
    orderRepository.deleteById(integer);
  }
}
