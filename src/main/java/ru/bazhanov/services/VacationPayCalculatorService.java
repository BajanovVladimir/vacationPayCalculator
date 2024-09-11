package ru.bazhanov.services;

import ru.bazhanov.models.VacationPayCalculatorDTO;

public interface VacationPayCalculatorService {
    Double getResult(VacationPayCalculatorDTO vacationPayCalculatorDTO);
}
