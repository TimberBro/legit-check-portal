package ru.epopov.legitcheck.webapi.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.epopov.legitcheck.webapi.model.LegitChecker;

public interface LegitCheckerRepository extends CrudRepository<LegitChecker, Integer> {

}
