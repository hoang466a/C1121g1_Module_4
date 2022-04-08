package com.customer.vn.controller;
import com.customer.vn.dto.CustomerDTO;
import com.customer.vn.dto.PassBookDTO;
import com.customer.vn.model.Customer;
import com.customer.vn.model.PassBook;
import com.customer.vn.model.Tenor;
import com.customer.vn.service.Impl.CustomerService;
import com.customer.vn.service.Impl.PassBookService;
import com.customer.vn.service.Impl.TenorService;
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
import java.util.List;
import java.util.Optional;

@Controller
public class PassBookController {
    @Autowired
    PassBookService passBookService;

    @Autowired
    CustomerService customerService;

    @Autowired
    TenorService tenorService;

    @GetMapping("/passbook/list")
    public ModelAndView showList(@PageableDefault
                                         (value=3,sort="idPassBook",direction = Sort.Direction.ASC)
                                         Pageable pageable,
                                 @RequestParam Optional<String> keyword){
        String keywordValue=keyword.orElse("");
        ModelAndView modelAndView=new ModelAndView("passbook/list");
        Page<PassBook> passBookList=passBookService.findAllPage(pageable);
        List<Customer> customerList=customerService.findAll();
        List<Tenor> tenorList=tenorService.findAll();
        modelAndView.addObject("customerList",customerList);
        modelAndView.addObject("passBookList",passBookList);
        modelAndView.addObject("tenorList",tenorList);
        return modelAndView;
    }

    @GetMapping("/passbook/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView=new ModelAndView("/passbook/create");
        PassBookDTO passBookDTO=new PassBookDTO();
        modelAndView.addObject("passBookDTO",passBookDTO);
        return modelAndView;
    }

    @PostMapping("/passbook/savePassBook")
    public ModelAndView savePassBook(@Valid @ModelAttribute PassBookDTO passBookDTO
            , BindingResult bindingResult){
        passBookDTO.validate(passBookDTO,bindingResult);

        if(bindingResult.hasFieldErrors()){
            ModelAndView modelAndView=new ModelAndView("/passbook/create");
            modelAndView.addObject("customerList",customerService.findAll());
            modelAndView.addObject("tenorList",tenorService.findAll());
            return modelAndView;
        } else {
            PassBook passBook = new PassBook();
            ModelAndView modelAndView=new ModelAndView("redirect:/passbook/list");
            BeanUtils.copyProperties(passBookDTO,passBook);
            passBookService.save(passBook);
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
