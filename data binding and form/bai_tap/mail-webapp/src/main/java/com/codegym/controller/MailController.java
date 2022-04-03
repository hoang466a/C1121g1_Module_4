package com.codegym.controller;

import com.codegym.model.Mail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("setting")
public class MailController {
    @GetMapping(value="/list")
    public String showForm(Model model)
    {
        model.addAttribute("mail",new Mail());
        return "list";
    }


    @PostMapping("/update")
    public String update(@ModelAttribute("mail") Mail mail,Model model){
        model.addAttribute("language",mail.getLanguage());
        model.addAttribute("pageSize",mail.getPageSize());
        model.addAttribute("spamFilter",mail.getSpamFilter());
        model.addAttribute("signature",mail.getSignature());
        model.addAttribute("message","cap nhat thanh cong");
        return "info";
    }

}
