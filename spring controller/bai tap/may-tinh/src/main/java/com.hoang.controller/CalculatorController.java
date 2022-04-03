package com.hoang.controller;


import com.hoang.service.CalculatorService;
import com.hoang.service.CalculatorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    CalculatorService calculatorService;

    @RequestMapping("/")
    public String home(){
        return "/calculator";
    }

    @GetMapping("cal")
    public String calculator (@RequestParam(defaultValue = "0")Double first, @RequestParam(defaultValue = "0")Double second, String calculate, Model model){
        String name=calculate;
        String result=calculatorService.calculate(first,second,calculate);
        model.addAttribute("name",name);
        model.addAttribute("result",result);
        return "/calculator";
    }







}
