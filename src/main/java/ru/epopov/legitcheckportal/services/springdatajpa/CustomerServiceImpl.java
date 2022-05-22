package ru.epopov.legitcheckportal.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityNotFoundException;
import ru.epopov.legitcheckportal.model.Customer;
import ru.epopov.legitcheckportal.repositories.CustomerRepository;
import ru.epopov.legitcheckportal.services.CustomerService;

public class CustomerServiceImpl implements CustomerService {

  private final CustomerRepository customerRepository;

  public CustomerServiceImpl(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @Override
  public Customer findById(Integer integer) {
    return customerRepository
        .findById(integer)
        .orElseThrow(
            () -> new EntityNotFoundException("Customer with id=" + integer + " was not found."));
  }

  @Override
  public Customer save(Customer object) {
    return customerRepository.save(object);
  }

  @Override
  public Set<Customer> findAll() {
    Set<Customer> customers = new HashSet<>();
    for (Customer customer : customerRepository.findAll()) {
      customers.add(customer);
    }
    return customers;
  }

  @Override
  public void delete(Customer object) {
    customerRepository.delete(object);
  }

  @Override
  public void deleteById(Integer integer) {
    customerRepository.deleteById(integer);
  }
}
