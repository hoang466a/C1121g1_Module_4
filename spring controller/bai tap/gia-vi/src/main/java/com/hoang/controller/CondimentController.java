package com.hoang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CondimentController {
    ModelAndView modelAndView;
    @RequestMapping("")
    public String home(){
        return "/condiment";
    }

    @GetMapping("/action")
    public ModelAndView show(@RequestParam(name="condiment",defaultValue = "noChoice")String []condiment){
        if(!condiment[0].equals("noChoice"))
        {
            modelAndView=new ModelAndView("condiment","list",condiment);
        }
        else{
            modelAndView=new ModelAndView("condiment","message","No toping was choice!");
        }
        return modelAndView;
    }



}
