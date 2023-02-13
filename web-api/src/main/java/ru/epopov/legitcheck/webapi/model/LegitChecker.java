package ru.epopov.legitcheck.webapi.model;

import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.ToString;
import lombok.ToString.Exclude;
import org.hibernate.Hibernate;

@Entity
@Getter
@ToString(callSuper = true)
public class LegitChecker extends AbstractUser {

  @Column(name = "rating")
  private Double rating = 0.0;

  @OneToMany(mappedBy = "legitChecker")
  @Exclude
  private Set<Order> orders;

  public void setOrders(Set<Order> orders) {
    this.orders = orders;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    LegitChecker that = (LegitChecker) o;
    return Objects.equals(getId(), that.getId());
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
