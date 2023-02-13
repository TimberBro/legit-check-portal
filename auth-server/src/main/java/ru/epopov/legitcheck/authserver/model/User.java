package ru.epopov.legitcheck.authserver.model;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.Type;
import org.springframework.lang.NonNull;

@Entity(name = "users")
public class User {

  @Column(name = "uuid")
  @Type(type = "uuid-char")
  private UUID uuid;

  @Id
  @Column(name = "username")
  @NonNull
  private String username;

  @Column(name = "password")
  @NonNull
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
