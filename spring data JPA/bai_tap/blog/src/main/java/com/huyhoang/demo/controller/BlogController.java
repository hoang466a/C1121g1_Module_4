package com.huyhoang.demo.controller;


import com.huyhoang.demo.model.Blog;
import com.huyhoang.demo.model.Category;
import com.huyhoang.demo.service.Impl.BlogService;
import com.huyhoang.demo.service.Impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blog/")
public class BlogController {
    @Autowired
    BlogService blogService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/list")
    public ModelAndView showList(@PageableDefault
                                             (value=3,sort="idBlog",direction = Sort.Direction.ASC)Pageable pageable,
                                 @RequestParam Optional<String>keyword){
        String keywordValue=keyword.orElse("");
        ModelAndView modelAndView=new ModelAndView("blog/list");
        Page<Blog> blogList=blogService.findAllPaging(keywordValue,pageable);
        List<Category> categoryList=categoryService.findAll();
        modelAndView.addObject("blogList",blogList);
        modelAndView.addObject("categoryList",categoryList);
        modelAndView.addObject("keywordValue",keywordValue);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate(Model model){
        ModelAndView modelAndView=new ModelAndView("blog/create");
        Blog blog=new Blog();
        List<Category> categoryList=categoryService.findAll();
        modelAndView.addObject("blog",blog);
        modelAndView.addObject("categoryList",categoryList);
        return modelAndView;
    }

    @PostMapping("/saveBlog")
    public ModelAndView saveBlog(@ModelAttribute("blog")Blog blog, Model model){
        ModelAndView modelAndView=new ModelAndView("redirect:/blog/list");
        LocalDate localDate=LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        String dateString = localDate.format(formatter);
        blog.setDateBlog(dateString);
        blogService.save(blog);
        return modelAndView;
    }

    @GetMapping("/{id}/view")
    public ModelAndView viewBlog(@PathVariable int id){
        ModelAndView modelAndView=new ModelAndView("/blog/view");
        Blog blog=blogService.findById(id);
        modelAndView.addObject("blog",blog);
        return modelAndView;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView editBlog(Model model,@PathVariable int id){
        ModelAndView modelAndView=new ModelAndView("blog/edit");
        Blog blog=blogService.findById(id);
        List<Category> categoryList=categoryService.findAll();
        modelAndView.addObject("blog",blog);
        modelAndView.addObject("categoryList",categoryList);
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView editAndSaveBlog(@ModelAttribute("blog")Blog blog){
        ModelAndView modelAndView=new ModelAndView("redirect:/blog/list");
        blogService.save(blog);
        return modelAndView;
    }

    @GetMapping("/blog/{id}/delete")
    public ModelAndView deleteBlog(Model model,@PathVariable int id){
        blogService.remove(id);
        ModelAndView modelAndView=new ModelAndView("redirect:/blog/list");
        return modelAndView;
    }



}
