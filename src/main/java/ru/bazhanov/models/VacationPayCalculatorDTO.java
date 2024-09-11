package ru.bazhanov.models;

import java.time.LocalDate;

public class VacationPayCalculatorDTO {
    private Double salary;
    private LocalDate startDate;
    private LocalDate stopDate;

    public VacationPayCalculatorDTO(){}

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getStopDate() {
        return stopDate;
    }

    public void setStopDate(LocalDate stopDate) {
        this.stopDate = stopDate;
    }
}
