package ru.epopov.legitcheckportal.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.epopov.legitcheckportal.model.LegitChecker;

public interface LegitCheckerRepository extends CrudRepository<LegitChecker, Integer> {

}
