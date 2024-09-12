package ru.bazhanov.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.bazhanov.dto.VacationPayCalculatorDTO;
import ru.bazhanov.models.VacationPayCalculator;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;


public class VacationPayCalculatorServiceImplTests {
    private final LocalDate dateStart = LocalDate.of(2024,2,3);
    private final LocalDate dateStop= LocalDate.of(2024,2,4);
    private final String dateStartString = String.valueOf(dateStart);
    private final String dateStopString = String.valueOf(dateStop);
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
    void test_that_getModel_is_ok_when_the_data_is_correct() {
        VacationPayCalculatorDTO vacationPayCalculatorDTO = new VacationPayCalculatorDTO();
        vacationPayCalculatorDTO.setSalary("80000");
        vacationPayCalculatorDTO.setStartDate(dateStartString);
        vacationPayCalculatorDTO.setStopDate(dateStopString);
        VacationPayCalculator vacationPayCalculator = vacationPayCalculatorService.getModel(vacationPayCalculatorDTO);
        Assertions.assertEquals(80000,vacationPayCalculator.getSalary());
    }
    @Test
    void test_that_getModel_throws_an_exception_when_the_salary_format_is_incorrect() {
        VacationPayCalculatorDTO vacationPayCalculatorDTO = new VacationPayCalculatorDTO();
        vacationPayCalculatorDTO.setSalary("ddffdf");
        vacationPayCalculatorDTO.setStartDate(dateStartString);
        vacationPayCalculatorDTO.setStopDate(dateStopString);
        Assertions.assertThrows(NumberFormatException.class, () -> vacationPayCalculatorService.getModel(vacationPayCalculatorDTO));
    }
    @Test
    void test_that_getModel_throws_an_exception_when_the_dateStart_format_is_incorrect() {
        VacationPayCalculatorDTO vacationPayCalculatorDTO = new VacationPayCalculatorDTO();
        vacationPayCalculatorDTO.setSalary("80000");
        vacationPayCalculatorDTO.setStartDate("2024-fdsfds");
        vacationPayCalculatorDTO.setStopDate(dateStopString);
        Assertions.assertThrows(DateTimeParseException.class, () -> vacationPayCalculatorService.getModel(vacationPayCalculatorDTO));
    }
    @Test
    void test_that_getModel_throws_an_exception_when_the_dateStop_format_is_incorrect() {
        VacationPayCalculatorDTO vacationPayCalculatorDTO = new VacationPayCalculatorDTO();
        vacationPayCalculatorDTO.setSalary("80000");
        vacationPayCalculatorDTO.setStartDate(dateStartString);
        vacationPayCalculatorDTO.setStopDate("45656gbxbj");
        Assertions.assertThrows(DateTimeParseException.class, () -> vacationPayCalculatorService.getModel(vacationPayCalculatorDTO));
    }
    @Test
    void test_that_getResult_is_ok(){
        VacationPayCalculatorDTO vacationPayCalculatorDTO = new VacationPayCalculatorDTO();
        vacationPayCalculatorDTO.setSalary("80000");
        vacationPayCalculatorDTO.setStartDate(dateStartString);
        vacationPayCalculatorDTO.setStopDate(dateStopString);
        VacationPayCalculator vacationPayCalculator = vacationPayCalculatorService.getModel(vacationPayCalculatorDTO);
        Assertions.assertEquals(5460.75,vacationPayCalculatorService.getResult(vacationPayCalculator));
    }
}
