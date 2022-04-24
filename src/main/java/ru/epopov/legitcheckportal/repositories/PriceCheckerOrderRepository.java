package ru.epopov.legitcheckportal.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.epopov.legitcheckportal.model.PriceCheckOrder;

public interface PriceCheckerOrderRepository extends CrudRepository<PriceCheckOrder, Integer> {

}
