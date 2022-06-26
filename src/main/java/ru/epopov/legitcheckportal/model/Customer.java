package ru.epopov.legitcheckportal.model;

import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.ToString;
import lombok.ToString.Exclude;
import org.hibernate.Hibernate;

@Entity
@Getter
@ToString(callSuper = true)
public class Customer extends AbstractUser {

  @OneToMany(mappedBy = "customer")
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
    Customer customer = (Customer) o;
    return Objects.equals(getId(), customer.getId());
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
