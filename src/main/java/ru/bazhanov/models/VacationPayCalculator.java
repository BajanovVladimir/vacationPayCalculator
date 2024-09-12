package ru.bazhanov.models;

import java.time.LocalDate;

public class VacationPayCalculator {
    private Double salary;
    private LocalDate startDate;
    private LocalDate stopDate;

    public VacationPayCalculator(Double salary,LocalDate startDate, LocalDate stopDate){
        this.salary = salary;
        this.startDate = startDate;
        this.stopDate = stopDate;
    }

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
