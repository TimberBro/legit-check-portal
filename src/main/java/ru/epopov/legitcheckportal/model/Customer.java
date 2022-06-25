package ru.epopov.legitcheckportal.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

// TODO: 24.06.2022 Merge customers and legitcheckers:
//  1) Might be a good solution to store them in one table, and add new column ROLE.
//  2) Try to use abstract class for entity and then extend it to customer and legitchecker
//  Also, need to use liquibase to control database migrations
@Entity
@Table(name = "CUSTOMERS")
@Data
public class Customer {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "customer_id")
  @Id
  private int id;

  @Column(name = "user_name")
  private String userName;
  @Column(name = "email")
  private String email;
  @Column(name = "password")
  private String password;

  @OneToMany(mappedBy = "customer")
  private Set<Order> orders;


}
