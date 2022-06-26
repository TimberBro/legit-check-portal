package ru.epopov.legitcheckportal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "USERS")
@Data
public abstract class AbstractUser {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  @Id
  private int id;

  @Column(name = "user_name")
  private String userName;
  @Column(name = "email")
  private String email;
  @Column(name = "password")
  private String password;

}
