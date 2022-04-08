package com.codegym.controller;


import com.codegym.model.Comment;
import com.codegym.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    ICommentService iCommentService;

    @GetMapping("")
    public ModelAndView showList(){
        ModelAndView modelAndView=new ModelAndView("list");
        Comment comment=new Comment();
        List<Comment> comments=iCommentService.findAllByDate();
        modelAndView.addObject("comments",comments);
        modelAndView.addObject("comment",comment);
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createComment(@ModelAttribute ("comment")Comment comment, Model model){
        iCommentService.save(comment);
        ModelAndView modelAndView=new ModelAndView("list");
        List<Comment> comments=iCommentService.findAllByDate();
        modelAndView.addObject("comments",comments);
        return modelAndView;
    }

    /*@GetMapping()
    public ModelAndView view(@PathVariable ){

    }*/


}
