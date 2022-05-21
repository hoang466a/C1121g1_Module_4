package com.casestudy.vn.webservice.customer;


import com.casestudy.vn.dto.customer.CustomerDTO;
import com.casestudy.vn.model.customer.Customer;
import com.casestudy.vn.model.customer.CustomerType;
import com.casestudy.vn.service.customer.ICustomerService;
import com.casestudy.vn.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/customer/")
@CrossOrigin
public class CustomerWebservice {
    @Autowired
    ICustomerTypeService customerTypeService;
    @Autowired
    ICustomerService customerService;

    @GetMapping
    public ResponseEntity<Page<Customer>> showList(@PageableDefault(value = 3, sort = "id", direction = Sort.Direction.ASC)
                                         Pageable pageable, @RequestParam Optional<String> keyword) {
        String keyWordValue = keyword.orElse("");
        Page<Customer> customerList = customerService.searchAllPage(keyWordValue, pageable);
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    /*@PostMapping
    public ResponseEntity createCustomer(@Valid @ModelAttribute CustomerDTO customerDTO,
                                     BindingResult bindingResult) {
        customerDTO.setContractSet(null);
        CustomerDTO customerDTO1=new CustomerDTO();
        customerDTO1.setiCustomerService(customerService);
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
    }*/



}
