package com.codegym.i18n_user.controller;

import com.codegym.i18n_user.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @GetMapping("/login")
    public ModelAndView showLogin(){
        ModelAndView modelAndView=new ModelAndView("/login");
        modelAndView.addObject("user",new User());
        return modelAndView;
    }

    @PostMapping("/loginForm")
    public ModelAndView login(@ModelAttribute User user){
        if(user.getUsername().equals("hoang")&& user.getPassword().equals("123456")){
                ModelAndView modelAndView=new ModelAndView("/success");
                modelAndView.addObject("user",user);
                return modelAndView;
        }
        ModelAndView modelAndView=new ModelAndView("/error");
        return  modelAndView;
    }

}
