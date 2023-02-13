package ru.epopov.legitcheck.webapi.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.epopov.legitcheck.webapi.model.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {

}
