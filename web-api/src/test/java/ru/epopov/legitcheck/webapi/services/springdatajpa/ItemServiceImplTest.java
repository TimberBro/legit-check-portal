package ru.epopov.legitcheck.webapi.services.springdatajpa;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigInteger;
import java.sql.Date;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.epopov.legitcheck.webapi.model.Item;
import ru.epopov.legitcheck.webapi.repositories.ItemRepository;
import ru.epopov.legitcheck.webapi.services.ItemService;

class ItemServiceImplTest {

  ItemService itemService;

  @Mock
  ItemRepository itemRepository;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    itemService = new ItemServiceImpl(itemRepository);
  }

  @Test
  void createIfNotExist() {
    Item item1 = new Item();
    item1.setItemName("Jordan Air 1");
    item1.setItemPrice(BigInteger.valueOf(170));
    item1.setColorName("University Blue");
    item1.setCategories("High;Jordan");
    item1.setManufacture("Jordan");
    item1.setReleaseDate(Date.valueOf("2021-06-03"));
    item1.setStockKeepingUnit("555088-134");
    item1.setSizeTag("US11");

    when(itemRepository.save(any())).thenReturn(item1);
    when(itemRepository.findById(anyInt())).thenReturn(Optional.empty());

    // 14 is a magic number. Maybe I'll replace it with constant variable.
    itemService.updateById(14, item1);

    //then
    verify(itemRepository, times(1)).findById(anyInt());
    verify(itemRepository, times(1)).save(any());
  }

  @Test
  void updateByIdTest() {
    //given
    Item item1 = new Item();
    item1.setItemName("Jordan Air 1");
    item1.setItemPrice(BigInteger.valueOf(170));
    item1.setColorName("University Blue");
    item1.setCategories("High;Jordan");
    item1.setManufacture("Jordan");
    item1.setReleaseDate(Date.valueOf("2021-06-03"));
    item1.setStockKeepingUnit("555088-134");
    item1.setSizeTag("US11");

    Item item2 = new Item();
    item2.setItemName("Yeezy 700");
    item2.setItemPrice(BigInteger.valueOf(240));
    item2.setColorName("Wash Orange");
    item2.setCategories("Low;Adidas;Yeezy");
    item2.setManufacture("Adidas");
    item2.setReleaseDate(Date.valueOf("2021-10-16"));
    item2.setStockKeepingUnit("GW0296");
    item2.setSizeTag("US7");

    //when
    when(itemRepository.save(any())).thenReturn(item2);
    when(itemRepository.findById(anyInt())).thenReturn(Optional.of(item1));
    itemService.updateById(1, item2);

    //then
    Assertions.assertEquals(item1, item2);
  }
}