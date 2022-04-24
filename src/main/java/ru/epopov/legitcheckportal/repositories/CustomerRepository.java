package ru.epopov.legitcheckportal.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.epopov.legitcheckportal.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
