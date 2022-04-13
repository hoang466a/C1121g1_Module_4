package com.example.dem_so_luong_view_trang.controller;

import com.example.dem_so_luong_view_trang.model.Counter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("count")
public class CouterController {
    @ModelAttribute("count")
    public Counter setUpCounter() {
        return new Counter();
    }
   @RequestMapping
    public String countView(@ModelAttribute("count") Counter counter, Model model) {
        counter.increment();
        model.addAttribute("numberOfView", counter.getCount());
        return "index";
    }
}
