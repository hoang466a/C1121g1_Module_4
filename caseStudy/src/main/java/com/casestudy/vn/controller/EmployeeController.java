package com.casestudy.vn.controller;

import com.casestudy.vn.dto.customer.CustomerDTO;
import com.casestudy.vn.model.customer.Customer;
import com.casestudy.vn.model.customer.CustomerType;
import com.casestudy.vn.model.employee.Employee;
import com.casestudy.vn.service.employee.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IDivivsionService divisionService;
    @Autowired
    private IEducationDegreeService educationDegreeService;
    @Autowired
    private IPositionService positionService;
    @Autowired
    private IUserService userService;


    @GetMapping("/employee")
    public ModelAndView showList(@PageableDefault(value=3,sort="employeeId",direction = Sort.Direction.ASC)
                                         Pageable pageable, @RequestParam Optional<String> keyword){
        String keyWordValue= keyword.orElse("");
        ModelAndView modelAndView=new ModelAndView("employee/list");
        Page<Employee> employeeList=employeeService.searchAllPage(keyWordValue,pageable);
        modelAndView.addObject("employeeList",employeeList);
        modelAndView.addObject("keyWordValue",keyWordValue);
        return modelAndView;
    }

   /* @GetMapping("/customer/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView=new ModelAndView("customer/create");
        CustomerDTO customerDTO=new CustomerDTO();
        List<CustomerType> customerTypeList=customerTypeService.findAll();
        modelAndView.addObject("customerTypeList",customerTypeList);
        modelAndView.addObject("customerDTO",customerDTO);
        return modelAndView;
    }

    @PostMapping("/customer/save")
    public ModelAndView saveCustomer(@Valid @ModelAttribute CustomerDTO customerDTO,
                                     BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            ModelAndView modelAndView=new ModelAndView("customer/create");
            //modelAndView.addObject("customerDTO",new CustomerDTO());
            modelAndView.addObject("customerTypeList",customerTypeService.findAll());
            return modelAndView;
        }
        else{
            Customer customer=new Customer();
            ModelAndView modelAndView=new ModelAndView("redirect:/customer");
            BeanUtils.copyProperties(customerDTO,customer);
            customerService.save(customer);
            return modelAndView;
        }*/
}
