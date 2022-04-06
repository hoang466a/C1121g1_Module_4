package com.huyhoang.demo.controller;


import com.huyhoang.demo.model.Blog;
import com.huyhoang.demo.model.Category;
import com.huyhoang.demo.service.Impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/category/list")
    public ModelAndView showList(@PageableDefault
                                         (value=3,sort="idCategory",direction = Sort.Direction.ASC) Pageable pageable){
        ModelAndView modelAndView=new ModelAndView("category/list");
        Page<Category> categoryList=categoryService.findAllPage(pageable);
        modelAndView.addObject("categoryList",categoryList);
        return modelAndView;
    }

    @GetMapping("/category/create")
    public ModelAndView showCreate(Model model){
        ModelAndView modelAndView=new ModelAndView("category/create");
        Category category=new Category();
        modelAndView.addObject("category",category);
        return modelAndView;
    }

    @PostMapping("/saveCategory")
    public ModelAndView saveCategory(@ModelAttribute("category")Category category,Model model){
        categoryService.save(category);
        ModelAndView modelAndView=new ModelAndView("redirect:/category/list");
        return modelAndView;
    }

    @GetMapping("/category/{id}/view")
    public ModelAndView viewCategory(@PathVariable int id){
        ModelAndView modelAndView=new ModelAndView("/category/view");
        Category category=categoryService.findById(id);
        modelAndView.addObject("category",category);
        return modelAndView;
    }

    @GetMapping("/category/{id}/edit")
    public ModelAndView editCategory(Model model,@PathVariable int id){
        ModelAndView modelAndView=new ModelAndView("category/edit");
        Category category=categoryService.findById(id);
        modelAndView.addObject("category",category);
        return modelAndView;
    }

    @PostMapping("/editCategory")
    public ModelAndView editAndSaveCategory(@ModelAttribute("category")Category category,Model model){
        categoryService.save(category);
        ModelAndView modelAndView=new ModelAndView("redirect:/category/list");
        return modelAndView;
    }

    @GetMapping("/category/{id}/delete")
    public ModelAndView deleteCategory(Model model,@PathVariable int id){
        categoryService.remove(id);
        ModelAndView modelAndView=new ModelAndView("redirect:/category/list");
        return modelAndView;
    }

}
