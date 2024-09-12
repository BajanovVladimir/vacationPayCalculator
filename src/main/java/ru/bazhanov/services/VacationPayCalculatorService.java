package ru.bazhanov.services;

import ru.bazhanov.dto.VacationPayCalculatorDTO;
import ru.bazhanov.models.VacationPayCalculator;

public interface VacationPayCalculatorService {
    Double getResult(VacationPayCalculator vacationPayCalculatorDTO);
    VacationPayCalculator getModel(VacationPayCalculatorDTO vacationPayCalculatorDTO);
}
