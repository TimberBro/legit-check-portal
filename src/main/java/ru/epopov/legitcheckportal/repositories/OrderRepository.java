package ru.epopov.legitcheckportal.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.epopov.legitcheckportal.model.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {

}
