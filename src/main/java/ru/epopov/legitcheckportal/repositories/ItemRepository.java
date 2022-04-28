package ru.epopov.legitcheckportal.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.epopov.legitcheckportal.model.Item;

public interface ItemRepository extends CrudRepository<Item, Integer> {


  @Query(value = "SELECT i FROM Item i WHERE i.id = ?1")
  Optional<Item> findById(Integer integer);
}
