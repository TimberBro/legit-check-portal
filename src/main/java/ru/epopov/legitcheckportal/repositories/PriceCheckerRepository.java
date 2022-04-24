package ru.epopov.legitcheckportal.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.epopov.legitcheckportal.model.PriceChecker;

public interface PriceCheckerRepository extends CrudRepository<PriceChecker, Integer> {

}
