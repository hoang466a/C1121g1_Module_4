package com.codegym.blog.controller;


import com.codegym.blog.model.Category;
import com.codegym.blog.service.Impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping(value="/category/list")
    public ResponseEntity<Page<Category>> showList(@PageableDefault
                                         (value=3,sort="idCategory",direction = Sort.Direction.ASC) Pageable pageable,
                                   @RequestParam Optional<String>keyword){
        String keywordValue=keyword.orElse("");
        Page<Category> categoryList=categoryService.findAllPaging(keywordValue,pageable);
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
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
