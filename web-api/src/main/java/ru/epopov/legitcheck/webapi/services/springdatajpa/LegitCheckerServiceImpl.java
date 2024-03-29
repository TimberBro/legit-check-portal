package ru.epopov.legitcheck.webapi.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Service;
import ru.epopov.legitcheck.webapi.model.LegitChecker;
import ru.epopov.legitcheck.webapi.repositories.LegitCheckerRepository;
import ru.epopov.legitcheck.webapi.services.LegitCheckerService;

@Service
public class LegitCheckerServiceImpl implements LegitCheckerService {

  private final LegitCheckerRepository legitCheckerRepository;

  public LegitCheckerServiceImpl(LegitCheckerRepository legitCheckerRepository) {
    this.legitCheckerRepository = legitCheckerRepository;
  }

  @Override
  public LegitChecker findById(Integer integer) {
    return legitCheckerRepository
        .findById(integer)
        .orElseThrow(
            () -> new RuntimeException("LegitChecker with id=" + integer + " was not found."));
  }

  @Override
  public LegitChecker save(LegitChecker object) {
    return legitCheckerRepository.save(object);
  }

  @Override
  public Set<LegitChecker> findAll() {
    Set<LegitChecker> legitCheckers = new HashSet<>();
    for (LegitChecker legitChecker : legitCheckerRepository.findAll()) {
      legitCheckers.add(legitChecker);
    }
    return legitCheckers;
  }

  @Override
  public void delete(LegitChecker object) {
    legitCheckerRepository.delete(object);
  }

  @Override
  public void deleteById(Integer integer) {
    legitCheckerRepository.deleteById(integer);
  }
}
