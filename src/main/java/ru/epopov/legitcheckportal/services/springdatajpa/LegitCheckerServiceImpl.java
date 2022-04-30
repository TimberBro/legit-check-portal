package ru.epopov.legitcheckportal.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;
import ru.epopov.legitcheckportal.model.LegitChecker;
import ru.epopov.legitcheckportal.repositories.LegitCheckerRepository;
import ru.epopov.legitcheckportal.services.LegitCheckerService;

public class LegitCheckerServiceImpl implements LegitCheckerService {

  private final LegitCheckerRepository legitCheckerRepository;

  public LegitCheckerServiceImpl(LegitCheckerRepository legitCheckerRepository) {
    this.legitCheckerRepository = legitCheckerRepository;
  }

  @Override
  public LegitChecker findById(Integer integer) {
    return legitCheckerRepository.findById(integer)
        .orElseThrow(() -> new RuntimeException("LegitChecker with id=" + integer + " was not found."));
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
