package ru.epopov.legitcheckportal.controllers;

import java.util.Set;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.epopov.legitcheckportal.model.Order;
import ru.epopov.legitcheckportal.services.OrderService;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

  private final OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @GetMapping("")
  Set<Order> allItems() {
    return orderService.findAll();
  }

  @GetMapping("/{id}")
  Order getItemById(@PathVariable int id) {
    return orderService.findById(id);
  }

  @PostMapping("")
  Order newItem(@RequestBody Order order) {
    return orderService.save(order);
  }

  @PutMapping("/{id}")
  Order replaceItem(@RequestBody Order order, @PathVariable int id) {
    Order savedOrder = orderService.findById(id);
    order.setId(savedOrder.getId());
    return orderService.save(order);
  }

  @DeleteMapping("/{id}")
  void deleteOrder(@PathVariable int id) {
    orderService.deleteById(id);
  }
}
