package ru.epopov.legitcheck.webapi.services.springdatajpa;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.epopov.legitcheck.webapi.model.Item;
import ru.epopov.legitcheck.webapi.repositories.ItemRepository;
import ru.epopov.legitcheck.webapi.services.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

  private static final Logger log = LoggerFactory.getLogger(ItemServiceImpl.class);

  private final ItemRepository itemRepository;

  public ItemServiceImpl(ItemRepository itemRepository) {
    this.itemRepository = itemRepository;
  }

  @Override
  public Item findById(Integer integer) {
    return itemRepository
        .findById(integer)
        .orElseThrow(
            () -> new EntityNotFoundException("Item with id=" + integer + " was not found."));
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

  @Override
  public Item updateById(int id, Item item) {
    try {
      Item itemToReplace = this.findById(id);
      Field[] fields = Item.class.getDeclaredFields();
      for (Field field : fields) {
        if (!field.getName().equals("id")) {
          PropertyDescriptor descriptor = null;
          try {
            descriptor = new PropertyDescriptor(field.getName(), Item.class);
          } catch (IntrospectionException e) {
            throw new RuntimeException(e);
          }
          Method getter = descriptor.getReadMethod();
          Method setter = descriptor.getWriteMethod();
          try {
            setter.invoke(itemToReplace, getter.invoke(item));
          } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
          }
        }
      }
      return this.save(itemToReplace);
    } catch (EntityNotFoundException e) {
      return this.save(item);
    }
  }
}
