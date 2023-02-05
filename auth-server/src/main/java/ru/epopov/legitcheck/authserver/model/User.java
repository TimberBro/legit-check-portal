package ru.epopov.legitcheck.authserver.model;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.Type;

@Entity(name = "users")
public class User {

  @Id
  @Column(name = "id")
  @Type(type = "uuid-char")
  private UUID uuid;

  @Column(name = "username")
  private String username;

  @Column(name = "password")
  private String password;

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
