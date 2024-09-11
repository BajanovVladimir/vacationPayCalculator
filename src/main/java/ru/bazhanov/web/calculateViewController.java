package ru.bazhanov.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/calculate")
public class calculateViewController {

    @GetMapping
    public ModelAndView showCalculateView(){
        ModelAndView mv = new ModelAndView("/calculationView");
        return mv;
    }


}
