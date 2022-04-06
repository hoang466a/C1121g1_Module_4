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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("")
public class BlogController {
    @Autowired
    BlogService blogService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/blog")
    public ModelAndView showList(@PageableDefault
                                             (value=3,sort="idBlog",direction = Sort.Direction.ASC)Pageable pageable){
        ModelAndView modelAndView=new ModelAndView("blog/list");
        Page<Blog> blogList=blogService.findAllPage(pageable);
        List<Category> categoryList=categoryService.findAll();
        modelAndView.addObject("blogList",blogList);
        modelAndView.addObject("categoryList",categoryList);
        return modelAndView;
    }

    @GetMapping("/blog/create")
    public ModelAndView showCreate(Model model){
        ModelAndView modelAndView=new ModelAndView("blog/create");
        Blog blog=new Blog();
        List<Category> categoryList=categoryService.findAll();
        modelAndView.addObject("blog",blog);
        modelAndView.addObject("categoryList",categoryList);
        return modelAndView;
    }


}
