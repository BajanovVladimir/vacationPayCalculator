package ru.bazhanov.services;

import org.springframework.stereotype.Service;
import ru.bazhanov.models.VacationPayCalculatorDTO;
import java.time.Duration;
import java.time.LocalDate;
@Service
public class VacationPayCalculatorServiceImpl implements VacationPayCalculatorService{

    @Override
    public Double getResult(VacationPayCalculatorDTO vacationPayCalculatorDTO) {
        Double AVERAGE_NUMBER_OF_DAYS_IN_MONTH = 29.3;
        double result = vacationPayCalculatorDTO.getSalary()/ AVERAGE_NUMBER_OF_DAYS_IN_MONTH *getNumberOfDays(vacationPayCalculatorDTO.getStartDate(),vacationPayCalculatorDTO.getStopDate());
        result = Math.round(result*100)/100.0;
        return result;
    }

    static public int getNumberOfDays(LocalDate startDate, LocalDate stopDate){
        return (int) Duration.between(startDate.atStartOfDay(),stopDate.atStartOfDay()).toDays()+1;
    }
}
