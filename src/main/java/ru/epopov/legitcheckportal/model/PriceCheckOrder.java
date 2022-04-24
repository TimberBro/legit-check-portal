package ru.epopov.legitcheckportal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "ORDERS")
@Data
public class PriceCheckOrder {

  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "order_id")
  @Id
  int id;

  @ManyToOne
  @JoinColumn(name = "customer_id")
  Customer customer;

  @ManyToOne
  @JoinColumn(name = "price_checker_id")
  PriceChecker priceChecker;

  byte[] photoToVerify;

  @ManyToOne
  Item itemToVerify;

  @Enumerated(EnumType.STRING)
  Status status;
}
