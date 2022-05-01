package ru.epopov.legitcheckportal.config;

import java.math.BigInteger;
import java.sql.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.epopov.legitcheckportal.model.Item;
import ru.epopov.legitcheckportal.model.LegitChecker;
import ru.epopov.legitcheckportal.repositories.ItemRepository;
import ru.epopov.legitcheckportal.repositories.LegitCheckerRepository;
import ru.epopov.legitcheckportal.repositories.OrderRepository;

@Configuration
class LoadDatabase {

  private final LegitCheckerRepository legitCheckerRepository;
  private final ItemRepository itemRepository;
  private final OrderRepository orderRepository;
  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  LoadDatabase(LegitCheckerRepository legitCheckerRepository, ItemRepository itemRepository,
      OrderRepository orderRepository) {
    this.legitCheckerRepository = legitCheckerRepository;
    this.itemRepository = itemRepository;
    this.orderRepository = orderRepository;
  }

  @Bean
  CommandLineRunner initDatabase() {
    return args -> {
      loadData();
    };
  }

  private void loadData() {
    // Create some legit checkers
    LegitChecker legitChecker1 = new LegitChecker();
    legitChecker1.setEmail("legitchecker1@gmail.com");
    legitChecker1.setUserName("legitchecker1");
    legitChecker1.setPassword("123");
    LegitChecker legitChecker2 = new LegitChecker();
    legitChecker2.setEmail("legitchecker2@gmail.com");
    legitChecker2.setUserName("legitchecker2");
    legitChecker2.setPassword("345");
    log.info("Preloading " + legitCheckerRepository.save(legitChecker1));
    log.info("Preloading " + legitCheckerRepository.save(legitChecker2));

    // Create some items
    Item item1 = new Item();
    item1.setItemName("Jordan Air 1");
    item1.setItemPrice(BigInteger.valueOf(170));
    item1.setColorName("University Blue");
    item1.setCategories("High;Jordan");
    item1.setManufacture("Jordan");
    item1.setReleaseDate(Date.valueOf("2021-06-03"));
    item1.setStockKeepingUnit("555088-134");
    item1.setSizeTag("US11");
    log.info("Preloading " + itemRepository.save(item1));
    Item item2 = new Item();
    item2.setItemName("Yeezy 700");
    item2.setItemPrice(BigInteger.valueOf(240));
    item2.setColorName("Wash Orange");
    item2.setCategories("Low;Adidas;Yeezy");
    item2.setManufacture("Adidas");
    item2.setReleaseDate(Date.valueOf("2021-10-16"));
    item2.setStockKeepingUnit("GW0296");
    item2.setSizeTag("US7");
    log.info("Preloading " + itemRepository.save(item2));
  }
}
