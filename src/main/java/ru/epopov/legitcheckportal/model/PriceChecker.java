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
@Table(name = "PRICE_CHECKERS")
@Data
public class PriceChecker {

  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "price_checker_id")
  @Id
  private int id;

  @Column(name = "user_name")
  private String userName;
  @Column(name = "email")
  private String email;
  @Column(name = "password")
  private String password;
  @Column(name = "rating")
  private Double rating;

  @OneToMany(mappedBy = "priceChecker")
  private Set<PriceCheckOrder> orders;


}
