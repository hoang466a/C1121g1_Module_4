package com.huyhoang.controller;


import com.huyhoang.service.IServiceDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    IServiceDictionary iServiceDictionary;

    @GetMapping("/")
    public String show()
    {
        return "/dictionary";
    }

    @GetMapping("/translate")
    public String translate(@RequestParam String english, Model model){
        String vietnamese=iServiceDictionary.translate(english);
        model.addAttribute("vietnamese",vietnamese);
        return "/dictionary";
    }
}
