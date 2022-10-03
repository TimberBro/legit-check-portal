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
  @JoinColumn(name = "verify_item_id")
  Item verifyItem;

  @Enumerated(EnumType.STRING)
      @Column(name = "status")
  Status status;
}
