package ru.epopov.legitcheckportal.services.springdatajpa;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.epopov.legitcheckportal.model.LegitChecker;
import ru.epopov.legitcheckportal.repositories.LegitCheckerRepository;

class LegitCheckerServiceImplTest {

  private final String SAMPLE_MAIL = "123@mail.ru";
  LegitCheckerServiceImpl legitCheckerService;

  @Mock
  LegitCheckerRepository legitCheckerRepository;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    legitCheckerService = new LegitCheckerServiceImpl(legitCheckerRepository);
  }


  @Test
  void saveLegitCheckerTest() {
    // given
    LegitChecker legitChecker = new LegitChecker();
    legitChecker.setEmail(SAMPLE_MAIL);

    //when
    when(legitCheckerRepository.save(any())).thenReturn(legitChecker);

    LegitChecker savedLegitChecker = legitCheckerService.save(legitChecker);

    //then
    assertNotNull(savedLegitChecker);
    Assertions.assertEquals(savedLegitChecker.getEmail(), SAMPLE_MAIL);
    verify(legitCheckerRepository, times(1)).save(any());
  }
}