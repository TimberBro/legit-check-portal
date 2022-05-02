package ru.epopov.legitcheckportal.services;

import ru.epopov.legitcheckportal.model.Item;

public interface ItemService extends CrudService<Item, Integer> {

  Item updateById(int id, Item item);
}
