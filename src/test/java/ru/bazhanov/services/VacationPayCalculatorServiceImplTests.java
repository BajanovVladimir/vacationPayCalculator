package ru.bazhanov.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.bazhanov.models.VacationPayCalculatorDTO;
import java.time.LocalDate;


public class VacationPayCalculatorServiceImplTests {
    private final LocalDate dateStart = LocalDate.of(2024,2,3);
    private final LocalDate dateStop= LocalDate.of(2024,2,4);
    private final VacationPayCalculatorService vacationPayCalculatorService = new VacationPayCalculatorServiceImpl();



    @Test
    void test_that_getNumberOfDays_is_ok_if_dateStart_before_dateStop(){
        int numberOfDays = VacationPayCalculatorServiceImpl.getNumberOfDays(dateStart,dateStop);
        Assertions.assertEquals(2,numberOfDays);
    }
    @Test
    void test_that_getNumberOfDays_is_0_if_dateStop_before_dateStart(){
        int numberOfDays = VacationPayCalculatorServiceImpl.getNumberOfDays(dateStop,dateStart);
        Assertions.assertEquals(0,numberOfDays);
    }
    @Test
    void test_that_getResult_is_ok() {
        VacationPayCalculatorDTO vacationPayCalculatorDTO = new VacationPayCalculatorDTO();
        vacationPayCalculatorDTO.setSalary(80000.0);
        vacationPayCalculatorDTO.setStartDate(dateStart);
        vacationPayCalculatorDTO.setStopDate(dateStop);
        Assertions.assertEquals(5460.75,vacationPayCalculatorService.getResult(vacationPayCalculatorDTO));
    }
}
