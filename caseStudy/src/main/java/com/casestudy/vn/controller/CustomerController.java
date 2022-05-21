package com.casestudy.vn.controller;

import com.casestudy.vn.dto.customer.CustomerDTO;
import com.casestudy.vn.dto.date.DateDto;
import com.casestudy.vn.model.customer.Customer;
import com.casestudy.vn.model.customer.CustomerType;
import com.casestudy.vn.repository.customer.ICustomerTypeRepository;
import com.casestudy.vn.service.customer.ICustomerService;
import com.casestudy.vn.service.customer.ICustomerTypeService;
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
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    ICustomerService customerService ;

    @Autowired
    ICustomerTypeService customerTypeService;

    DateDto dateDto=new DateDto();

    @GetMapping("/")
    public ModelAndView showIndex() {
        ModelAndView modelAndView = new ModelAndView("/start");
        return modelAndView;
    }

    @GetMapping("/customer")
    public ModelAndView showList(@PageableDefault(value = 3, sort = "id", direction = Sort.Direction.ASC)
                                         Pageable pageable, @RequestParam Optional<String> keyword) {
        String keyWordValue = keyword.orElse("");
        ModelAndView modelAndView = new ModelAndView("customer/list");
        Page<Customer> customerList = customerService.searchAllPage(keyWordValue, pageable);



        modelAndView.addObject("customerList", customerList);
        modelAndView.addObject("keyWordValue", keyWordValue);
        return modelAndView;
    }

    @GetMapping("/customer/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("customer/create");
        CustomerDTO customerDTO = new CustomerDTO();
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        modelAndView.addObject("customerTypeList", customerTypeList);
        modelAndView.addObject("customerDTO", customerDTO);
        return modelAndView;
    }

    @PostMapping("/customer/save")
    public ModelAndView saveCustomer(@Valid @ModelAttribute CustomerDTO customerDTO,
                                     BindingResult bindingResult) {
        customerDTO.setContractSet(null);
        CustomerDTO customerDTO1=new CustomerDTO();
        //customerDTO1.setiCustomerService(customerService);
        customerDTO1.validate(customerDTO,bindingResult);
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("customer/create");
            //modelAndView.addObject("customerDTO",new CustomerDTO());
            modelAndView.addObject("customerTypeList", customerTypeService.findAll());
            return modelAndView;
        } else {
            Customer customer = new Customer();
            ModelAndView modelAndView = new ModelAndView("redirect:/customer");
            BeanUtils.copyProperties(customerDTO, customer);
            customerService.save(customer);
            return modelAndView;
        }
    }

    @GetMapping("/customer/{id}/edit")
    public ModelAndView showEdit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("customer/edit");
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customerService.findById(id), customerDTO);
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        modelAndView.addObject("customerTypeList", customerTypeList);
        modelAndView.addObject("customerDTO", customerDTO);
        return modelAndView;
    }

    @PostMapping("/customer/fix")
    public ModelAndView fixCustomer(@Valid @ModelAttribute("customerDTO") CustomerDTO customerDTO,
                                    BindingResult bindingResult) {
        customerDTO.setContractSet(null);
        CustomerDTO customerDTO1=new CustomerDTO();
        customerDTO1.setiCustomerService(customerService);
        customerDTO1.validate(customerDTO,bindingResult);
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("customer/create");
            modelAndView.addObject("customerTypeList", customerTypeService.findAll());
            return modelAndView;
        } else {
            Customer customer = new Customer();
            ModelAndView modelAndView = new ModelAndView("redirect:/customer");
            BeanUtils.copyProperties(customerDTO, customer);
            customerService.save(customer);
            return modelAndView;
        }
    }

    @GetMapping("/customer/{id}/view")
    public ModelAndView showView(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("customer/view");
        modelAndView.addObject("customer", customerService.findById(id));
        return modelAndView;
    }

    @PostMapping("/remove")
    public ModelAndView delete(@RequestParam Integer idDelete) {
        ModelAndView modelAndView=new ModelAndView("redirect:/customer");
        customerService.remove(idDelete);
        return modelAndView;
    }



}
