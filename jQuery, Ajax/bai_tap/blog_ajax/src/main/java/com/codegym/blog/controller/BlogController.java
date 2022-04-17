package com.codegym.blog.controller;


import com.codegym.blog.dto.BlogDTO;
import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import com.codegym.blog.service.Impl.BlogService;
import com.codegym.blog.service.Impl.CategoryService;
import org.springframework.beans.BeanUtils;
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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value="/blog/")
public class BlogController {
    @Autowired
    BlogService blogService;

    @Autowired
    CategoryService categoryService;

    @GetMapping(value="/list")
    public ResponseEntity<Page<Blog>> showList(@PageableDefault
                                             (value=3,sort="idBlog",direction = Sort.Direction.ASC)Pageable pageable,
                                   @RequestParam Optional<String>keyword){
        String keywordValue=keyword.orElse("");
        Page<Blog> blogList=blogService.findAllPaging(keywordValue,pageable);
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping(value="/list")
    public ModelAndView showAll(@PageableDefault
                                             (value=3,sort="idBlog",direction = Sort.Direction.ASC)Pageable pageable,
                                   @RequestParam Optional<String>keyword){
        String keywordValue=keyword.orElse("");
        ModelAndView modelAndView=new ModelAndView("/blog/list");
        modelAndView.addObject("blogList",blogService.findAllPaging(keywordValue,pageable));
        return modelAndView;
    }

    @GetMapping(value="/category/{id}")
    public ResponseEntity<Page<Blog>> showListBlog(@PageableDefault
            (value=3,sort="idBlog",direction = Sort.Direction.ASC)Pageable pageable,
                                                   @PathVariable Integer id){
        Page<Blog> blogListByCate=blogService.findAllByCateId(id,pageable);
        if(blogListByCate==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(blogListByCate, HttpStatus.OK);
    }


    @PostMapping(value="/create")
    public ResponseEntity<Void> createBlog(@RequestBody BlogDTO blogDTO
    ){
        Blog blogObj=new Blog();
        BeanUtils.copyProperties(blogDTO, blogObj);
        LocalDate localDate=LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        String dateString = localDate.format(formatter);
        Category category=new Category();
        category.setIdCategory(blogDTO.getCategoryOb().getIdCategory());
        blogObj.setCategoryOb(category);
        blogObj.setDateBlog(dateString);
        blogService.save(blogObj);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Blog> viewBlog(@PathVariable int id){
        Blog blog=blogService.findById(id);
        if(blog==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }


    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> deleteBlog(@PathVariable int id){
        Blog blog=blogService.findById(id);
        if(blog==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        blogService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
