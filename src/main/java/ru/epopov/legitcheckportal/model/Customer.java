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

@Entity
@Table(name = "CUSTOMERS")
@Data
public class Customer {

  @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
  private Set<PriceCheckOrder> orders;


}
