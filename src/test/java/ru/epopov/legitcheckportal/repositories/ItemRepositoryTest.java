package ru.epopov.legitcheckportal.repositories;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.epopov.legitcheckportal.model.Item;

@DataJpaTest
class ItemRepositoryTest {

  @Autowired
  ItemRepository itemRepository;

  @BeforeEach
  void setUp() {
    itemRepository.save(new Item());
  }

  @Test
  void findById() {
    Item foundItem = itemRepository.findById(1).get();
    Assertions.assertEquals(foundItem.getId(), 1);
  }
}