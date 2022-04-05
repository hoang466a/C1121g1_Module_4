package com.hoang.controller;


import com.hoang.model.Comment;
import com.hoang.repository.ICommentRepository;
import com.hoang.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    ICommentService iCommentService;

    @GetMapping("/")
    public ModelAndView showList(){
        ModelAndView modelAndView=new ModelAndView("list");
        List<Comment> comments=iCommentService.findAllByDate();
        modelAndView.addObject("comments",comments);
        return modelAndView;
    }



}
