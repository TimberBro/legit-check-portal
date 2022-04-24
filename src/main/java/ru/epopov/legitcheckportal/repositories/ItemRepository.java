package ru.epopov.legitcheckportal.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.epopov.legitcheckportal.model.Item;

public interface ItemRepository extends CrudRepository<Item, Integer> {

}
