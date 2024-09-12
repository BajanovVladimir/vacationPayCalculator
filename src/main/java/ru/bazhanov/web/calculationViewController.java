package ru.bazhanov.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.bazhanov.dto.VacationPayCalculatorDTO;
import ru.bazhanov.models.VacationPayCalculator;
import ru.bazhanov.services.VacationPayCalculatorService;
import ru.bazhanov.services.VacationPayCalculatorServiceImpl;
import java.time.format.DateTimeParseException;

@Controller
@RequestMapping("/calculate")
public class calculationViewController {

    private final VacationPayCalculatorService vacationPayCalculatorService = new VacationPayCalculatorServiceImpl();

    @GetMapping
    public ModelAndView showCalculateView(){
        ModelAndView mv = new ModelAndView("/calculationView");
        mv.addObject("vacationPayDTO",new VacationPayCalculatorDTO());
        return mv;
    }

    @PostMapping
    public ModelAndView calculationVacationPay(@ModelAttribute("vacationPayDTO") VacationPayCalculatorDTO calculatorDTO){
        boolean error = false;
        boolean dateError = false;
        ModelAndView mv = new ModelAndView("/calculationView");
        try{
            VacationPayCalculator vacationPayCalculator = vacationPayCalculatorService.getModel(calculatorDTO);
            if(vacationPayCalculator.getStartDate().isBefore(vacationPayCalculator.getStopDate())){
                mv.addObject("salary",calculatorDTO.getSalary());
                mv.addObject("numberOfDays", VacationPayCalculatorServiceImpl.getNumberOfDays(vacationPayCalculator.getStartDate(),vacationPayCalculator.getStopDate()));
                mv.addObject("startDay",vacationPayCalculator.getStartDate());
                mv.addObject("stopDay",vacationPayCalculator.getStopDate());
                mv.addObject("vacationPay",new VacationPayCalculatorServiceImpl().getResult(vacationPayCalculator));
            } else {
                dateError = true;
              }

        } catch (NumberFormatException | DateTimeParseException e){
            error = true;
        }
        mv.addObject("error", error);
        mv.addObject("dateError", dateError);
        return  mv;
    }
}
