package ru.epopov.legitcheckportal.services;

import ru.epopov.legitcheckportal.model.Order;

public interface OrderService extends CrudService<Order, Integer> {
  Order save(Order object);
}
