package ru.bazhanov.services;

import org.springframework.stereotype.Service;
import ru.bazhanov.dto.VacationPayCalculatorDTO;
import ru.bazhanov.models.VacationPayCalculator;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Service
public class VacationPayCalculatorServiceImpl implements VacationPayCalculatorService{

    @Override
    public Double getResult(VacationPayCalculator vacationPayCalculator) {
        Double AVERAGE_NUMBER_OF_DAYS_IN_MONTH = 29.3;
        try{
            double result = vacationPayCalculator.getSalary()/ AVERAGE_NUMBER_OF_DAYS_IN_MONTH *getNumberOfDays(vacationPayCalculator.getStartDate(),vacationPayCalculator.getStopDate());
            result = Math.round(result*100)/100.0;
            return result;
        } catch (NumberFormatException e){
            return  null;
        }
    }
    public VacationPayCalculator getModel(VacationPayCalculatorDTO vacationPayCalculatorDTO) throws NumberFormatException, DateTimeParseException {
            Double salary = Double.valueOf(vacationPayCalculatorDTO.getSalary());
            LocalDate startDate = LocalDate.parse(vacationPayCalculatorDTO.getStartDate());
            LocalDate stopDate = LocalDate.parse(vacationPayCalculatorDTO.getStopDate());
            return new VacationPayCalculator(salary,startDate,stopDate);
    }
    static public int getNumberOfDays(LocalDate startDate, LocalDate stopDate){
        return (int) Duration.between(startDate.atStartOfDay(),stopDate.atStartOfDay()).toDays()+1;
    }
}
