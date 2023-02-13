package ru.epopov.legitcheck.webapi.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.epopov.legitcheck.webapi.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
