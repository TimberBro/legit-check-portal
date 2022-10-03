package ru.epopov.legitcheckportal.controllers;

import java.util.Set;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.epopov.legitcheckportal.model.Item;
import ru.epopov.legitcheckportal.services.ItemService;

@RestController
@RequestMapping("/api/v1/items")
public class ItemController {

  private final ItemService itemService;

  public ItemController(ItemService itemService) {
    this.itemService = itemService;
  }

  @GetMapping("")
  Set<Item> allItems() {
    return itemService.findAll();
  }

  @GetMapping("/{id}")
  Item getItemById(@PathVariable int id) {
    return itemService.findById(id);
  }

  @PostMapping("")
  Item newItem(@RequestBody Item item) {
    return itemService.save(item);
  }

  @PutMapping("/{id}")
  Item replaceItem(@RequestBody Item item, @PathVariable int id) {
    return itemService.updateById(id, item);
  }

  @DeleteMapping("/{id}")
  void deleteItem(@PathVariable int id) {
    itemService.deleteById(id);
  }
}
