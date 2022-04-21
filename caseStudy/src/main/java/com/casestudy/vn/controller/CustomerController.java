package com.casestudy.vn.controller;

import com.casestudy.vn.model.customer.Customer;
import com.casestudy.vn.repository.customer.ICustomerTypeRepository;
import com.casestudy.vn.service.customer.ICustomerService;
import com.casestudy.vn.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.awt.event.KeyEvent;
import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @Autowired
    ICustomerTypeService customerTypeService;

    @GetMapping("/")
    public ModelAndView showIndex(){
        ModelAndView modelAndView=new ModelAndView("/start");
        return modelAndView;
    }

    @GetMapping("/customer")
    public ModelAndView showList(@PageableDefault(value=3,sort="customerId",direction = Sort.Direction.ASC)
                                             Pageable pageable,@RequestParam Optional<String> keyword){
        String keyWordValue= keyword.orElse("");
        ModelAndView modelAndView=new ModelAndView("customer/list");
        Page<Customer> customerList=customerService.searchAllPage(keyWordValue,pageable);
        modelAndView.addObject("customerList",customerList);
        modelAndView.addObject("keyWordValue",keyWordValue);
        return modelAndView;
    }




}
