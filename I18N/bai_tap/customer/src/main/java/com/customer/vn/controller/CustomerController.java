package com.customer.vn.controller;
import com.customer.vn.dto.CustomerDTO;
import com.customer.vn.model.Customer;
import com.customer.vn.service.Impl.CustomerService;
import com.customer.vn.service.Impl.PassBookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    PassBookService passBookService;

    @GetMapping("/customer/list")
    public ModelAndView showList(@PageableDefault
                                             (value=3,sort="idCustomer",direction = Sort.Direction.ASC)
                                             Pageable pageable,
                                             @RequestParam Optional<String> keyword){
        String keywordValue=keyword.orElse("");
        ModelAndView modelAndView=new ModelAndView("customer/list");
        Page<Customer> customerList=customerService.findAllPaging(keywordValue,pageable);
        modelAndView.addObject("customerList",customerList);
        modelAndView.addObject("keywordValue",keywordValue);
        return modelAndView;
    }

    @GetMapping("/customer/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView=new ModelAndView("/customer/create");
        CustomerDTO customerDTO=new CustomerDTO();
        modelAndView.addObject("customerDTO",customerDTO);
        return modelAndView;
    }

    @PostMapping("/customer/saveCustomer")
    public ModelAndView saveCustomer(@Valid @ModelAttribute CustomerDTO customerDTO
            , BindingResult bindingResult){

        if(bindingResult.hasFieldErrors()){
            ModelAndView modelAndView=new ModelAndView("/customer/create");
            return modelAndView;
        } else {
            Customer customer = new Customer();
            ModelAndView modelAndView=new ModelAndView("redirect:/customer/list");
            BeanUtils.copyProperties(customerDTO,customer);
            customerService.save(customer);
            return modelAndView;
        }
    }

    @GetMapping("customer/{id}/view")
    public ModelAndView viewCustomer(@PathVariable int id){
        ModelAndView modelAndView=new ModelAndView("/customer/view");
        Customer customer=customerService.findById(id);
        modelAndView.addObject("customer",customer);
        return modelAndView;
    }


    @GetMapping("customer/{id}/edit")
    public ModelAndView editCustomer(@PathVariable int id){
        ModelAndView modelAndView=new ModelAndView("customer/edit");
        Customer customer=customerService.findById(id);
        CustomerDTO customerDTO=new CustomerDTO();
        BeanUtils.copyProperties(customer,customerDTO);
        modelAndView.addObject("customerDTO",customerDTO);
        return modelAndView;
    }


    @PostMapping("customer/update")
    public ModelAndView editAndSaveCustomer(@Valid @ModelAttribute CustomerDTO customerDTO,
                                            BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            ModelAndView modelAndView=new ModelAndView("/customer/edit");
            return modelAndView;
        } else {
            Customer customer = new Customer();
            ModelAndView modelAndView=new ModelAndView("redirect:/customer/list");
            BeanUtils.copyProperties(customerDTO,customer);
            customerService.save(customer);
            return modelAndView;
        }
    }


    @GetMapping("/blog/{id}/delete")
    public ModelAndView deleteCustomer(@PathVariable int id){
        customerService.remove(id);
        ModelAndView modelAndView=new ModelAndView("redirect:/blog/list");
        return modelAndView;
    }

}
