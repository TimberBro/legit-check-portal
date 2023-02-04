package ru.epopov.legitcheck.webapi.services;

import ru.epopov.legitcheck.webapi.model.Item;

public interface ItemService extends CrudService<Item, Integer> {

  Item updateById(int id, Item item);
}
