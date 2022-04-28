package ru.epopov.legitcheckportal.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Service;
import ru.epopov.legitcheckportal.model.Item;
import ru.epopov.legitcheckportal.repositories.ItemRepository;
import ru.epopov.legitcheckportal.services.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

  private final ItemRepository itemRepository;

  public ItemServiceImpl(ItemRepository itemRepository) {
    this.itemRepository = itemRepository;
  }

  @Override
  public Item findById(Integer integer) {
    return itemRepository.findById(integer)
        .orElseThrow(() -> new RuntimeException("Item with id=" + integer + " was not found."));
  }

  @Override
  public Item save(Item object) {
    return itemRepository.save(object);
  }

  @Override
  public Set<Item> findAll() {
    Set<Item> items = new HashSet<>();
    for (Item item : itemRepository.findAll()) {
      items.add(item);
    }
    return items;
  }

  @Override
  public void delete(Item object) {
    itemRepository.delete(object);
  }

  @Override
  public void deleteById(Integer integer) {
    itemRepository.deleteById(integer);
  }
}
