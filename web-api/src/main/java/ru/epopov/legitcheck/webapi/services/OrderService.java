package ru.epopov.legitcheck.webapi.services;

import ru.epopov.legitcheck.webapi.model.Order;

public interface OrderService extends CrudService<Order, Integer> {
  Order save(Order object);
}
