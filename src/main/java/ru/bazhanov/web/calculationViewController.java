package ru.bazhanov.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.bazhanov.models.VacationPayCalculatorDTO;
import ru.bazhanov.services.VacationPayCalculatorServiceImpl;

@Controller
@RequestMapping("/calculate")
public class calculationViewController {

    @GetMapping
    public ModelAndView showCalculateView(){
        ModelAndView mv = new ModelAndView("/calculationView");
        mv.addObject("vacationPayDTO",new VacationPayCalculatorDTO());
        return mv;
    }

    @PostMapping
    public ModelAndView calculationVacationPay(@ModelAttribute("vacationPayDTO") VacationPayCalculatorDTO calculatorDTO){
        ModelAndView mv = new ModelAndView("/calculationView");
        mv.addObject("salary",calculatorDTO.getSalary());
        mv.addObject("numberOfDays", VacationPayCalculatorServiceImpl.getNumberOfDays(calculatorDTO.getStartDate(),calculatorDTO.getStopDate()));
        mv.addObject("startDay",calculatorDTO.getStartDate());
        mv.addObject("stopDay",calculatorDTO.getStopDate());
        mv.addObject("vacationPay",new VacationPayCalculatorServiceImpl().getResult(calculatorDTO));
        return  mv;
    }
}
