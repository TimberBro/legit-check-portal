package ru.epopov.legitcheckportal.config;

import java.math.BigInteger;
import java.sql.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.epopov.legitcheckportal.model.Customer;
import ru.epopov.legitcheckportal.model.Item;
import ru.epopov.legitcheckportal.model.LegitChecker;
import ru.epopov.legitcheckportal.services.CustomerService;
import ru.epopov.legitcheckportal.services.ItemService;
import ru.epopov.legitcheckportal.services.LegitCheckerService;
import ru.epopov.legitcheckportal.services.OrderService;

@Configuration
class LoadDatabase {

  private final LegitCheckerService legitCheckerService;
  private final ItemService itemService;
  private final OrderService orderService;
  private final CustomerService customerService;
  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  LoadDatabase(LegitCheckerService legitCheckerService, ItemService itemService,
      OrderService orderService, CustomerService customerService) {
    this.legitCheckerService = legitCheckerService;
    this.itemService = itemService;
    this.orderService = orderService;
    this.customerService = customerService;
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
    log.info("Preloading " + legitCheckerService.save(legitChecker1));
    log.info("Preloading " + legitCheckerService.save(legitChecker2));

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
    log.info("Preloading " + itemService.save(item1));
    Item item2 = new Item();
    item2.setItemName("Yeezy 700");
    item2.setItemPrice(BigInteger.valueOf(240));
    item2.setColorName("Wash Orange");
    item2.setCategories("Low;Adidas;Yeezy");
    item2.setManufacture("Adidas");
    item2.setReleaseDate(Date.valueOf("2021-10-16"));
    item2.setStockKeepingUnit("GW0296");
    item2.setSizeTag("US7");
    log.info("Preloading " + itemService.save(item2));

    Customer customer1 = new Customer();
    customer1.setEmail("customer1@gmail.com");
    customer1.setUserName("customer1");
    customer1.setPassword("678");
    log.info("Preloading " + customerService.save(customer1));
    Customer customer2 = new Customer();
    customer2.setEmail("customer2@gmail.com");
    customer2.setUserName("customer2");
    customer2.setPassword("890");
    log.info("Preloading " + customerService.save(customer2));
  }
}
