package controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("/")
    public String show(){
        return "transfer";
    }

    @GetMapping("convert")
    public String convert(@RequestParam double usd, double scale, Model model){
        double vnd=usd*scale;
        model.addAttribute("vnd",vnd);
        return "transfer";
    }



}
