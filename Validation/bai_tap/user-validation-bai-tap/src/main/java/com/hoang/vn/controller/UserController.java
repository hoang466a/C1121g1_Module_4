package com.hoang.vn.controller;


import com.hoang.vn.dto.UserDTO;
import com.hoang.vn.model.User;
import com.hoang.vn.service.IUserService;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.*;
import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("/user/list")
    public ModelAndView showList(@PageableDefault(value=3,sort="idUser",direction= Sort.Direction.ASC)Pageable pageable,
                                 @RequestParam Optional<String> keyword){
        String keywordValue=keyword.orElse("");
        ModelAndView modelAndView=new ModelAndView("user/list");
        Page<User>userList=userService.findAllPaging(keywordValue,pageable);
        modelAndView.addObject("userList",userList);
        modelAndView.addObject("keywordValue",keywordValue);
        return modelAndView;
    }

    @GetMapping("/user/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView=new ModelAndView("/user/create");
        UserDTO userDTO=new UserDTO();
        modelAndView.addObject("userDTO",userDTO);
        return modelAndView;
    }

    @PostMapping("/user/saveUser")
    public ModelAndView saveUser(@Valid @ModelAttribute UserDTO userDTO
                                , BindingResult bindingResult){
        userDTO.validate(userDTO, bindingResult);
        User user = new User();
        if(bindingResult.hasFieldErrors()){
            ModelAndView modelAndView=new ModelAndView("/user/create");
//            UserDTO userDTO1=new UserDTO();
//            modelAndView.addObject("user",userDTO1);
            return modelAndView;
        } else {
            ModelAndView modelAndView=new ModelAndView("redirect:/user/list");
            BeanUtils.copyProperties(userDTO,user);
            userService.save(user);
            return modelAndView;
        }
    }






}
