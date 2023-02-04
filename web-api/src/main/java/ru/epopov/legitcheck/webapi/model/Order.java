package ru.epopov.legitcheck.webapi.model;

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
public class Order {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "order_id")
  @Id
  int id;

  @ManyToOne
  @JoinColumn(name = "customer_id")
  Customer customer;

  @ManyToOne
  @JoinColumn(name = "legit_checker_id")
  LegitChecker legitChecker;

  String verifyPhotoPath;

  @ManyToOne
  Item verifyItem;

  @Enumerated(EnumType.STRING)
  Status status;
}
