package com.example.customphonevalidation.Controller;


import com.example.customphonevalidation.Model.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class PhoneController {
    @GetMapping("/")
    public String showForm(Model model){
        model.addAttribute("phoneNumber",new PhoneNumber());
        return "/index";
    }

    @PostMapping("/login")
    public String login(@Valid  PhoneNumber phoneNumber, BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            return "/index";
        }else{
            model.addAttribute("phoneNumber",phoneNumber);
            return "/result";
        }
    }


}


