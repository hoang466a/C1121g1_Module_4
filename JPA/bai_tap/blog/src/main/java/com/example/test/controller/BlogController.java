package com.example.test.controller;


import com.example.test.model.Blog;
import com.example.test.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ThreeTenBackPortConverters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping({"/blog",""})
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping("")
    public String showAll(Model model){
        List<Blog> blogList=blogService.findAll();
        model.addAttribute("blogList",blogList);
        return"/index";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("blog",new Blog());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Blog blog, RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message","Add new blog successfull");
        return "redirect:/blog";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id,Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String fix(Blog blog, Model model){
        blogService.save(blog);
        List<Blog>blogList= blogService.findAll();
        model.addAttribute("blogList",blogList);
        return "/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model){
        Blog blog=blogService.findById(id);
        model.addAttribute("blog",blog);
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete_db(RedirectAttributes redirectAttributes,Blog blog){
        blogService.delete(blog);
        redirectAttributes.addFlashAttribute("message","Delete Blog succes!");
        return "redirect:/blog";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id,Model model){
        Blog blog=blogService.findOne(id);
        model.addAttribute("blog",blog);
        return "/view";
    }





}
