package com.casestudy.vn.controller;

import com.casestudy.vn.dto.contract.ContractDto;
import com.casestudy.vn.dto.customer.CustomerDTO;
import com.casestudy.vn.model.contract.Contract;
import com.casestudy.vn.model.customer.Customer;
import com.casestudy.vn.model.employee.Employee;
import com.casestudy.vn.model.service_furama.Service;
import com.casestudy.vn.repository.contract.IAttachServiceRepository;
import com.casestudy.vn.service.contract.IAttachServiceService;
import com.casestudy.vn.service.contract.IContractDetailService;
import com.casestudy.vn.service.contract.IContractService;
import com.casestudy.vn.service.customer.ICustomerService;
import com.casestudy.vn.service.employee.IEmployeeService;
import com.casestudy.vn.service.service_furama.IServiceService;
import net.bytebuddy.asm.Advice;
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
public class ContractController {
    @Autowired
    IAttachServiceService attachServiceService;
    @Autowired
    IContractService contractService;
    @Autowired
    IContractDetailService contractDetailService;
    @Autowired
    IEmployeeService employeeService;
    @Autowired
    ICustomerService customerService;
    @Autowired
    IServiceService serviceService;

    @GetMapping("/contract")
    public ModelAndView showAll(@PageableDefault(value = 3,sort = "contractId",direction = Sort.Direction.ASC)
                                            Pageable pageable, @RequestParam Optional<String> keyword){
        String keywordValue=keyword.orElse("");
        ModelAndView modelAndView=new ModelAndView("/contract/list");
        modelAndView.addObject("contractList",contractService.searchAllPage(keywordValue,pageable));

        return modelAndView;
    }

    @GetMapping("/contract/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView=new ModelAndView("contract/create");
        ContractDto contractDto=new ContractDto();
        modelAndView.addObject("contractDto" ,contractDto);
        modelAndView.addObject("employeeList",employeeService.findAll());
        modelAndView.addObject("customerList",customerService.findAll());
        modelAndView.addObject("serviceList",serviceService.findAll());
        return modelAndView;
    }

    @PostMapping("/contract/save")
    public ModelAndView saveContract(@Valid @ModelAttribute ContractDto contractDto,
                                     BindingResult bindingResult){
        contractDto.validate(contractDto,bindingResult);
        if(bindingResult.hasErrors()){
            ModelAndView modelAndView=new ModelAndView("contract/create");
            modelAndView.addObject("employeeList",employeeService.findAll());
            modelAndView.addObject("customerList",customerService.findAll());
            modelAndView.addObject("serviceList",serviceService.findAll());
            return modelAndView;
        }
        else{
            Contract contract=new Contract();
            ModelAndView modelAndView=new ModelAndView("redirect:/contract");
            BeanUtils.copyProperties(contractDto,contract);
            contractService.save(contract);
            return modelAndView;
        }
    }

   /* @GetMapping("/contract/{id}/view")
    public ModelAndView showView(@PathVariable int id){
        ModelAndView modelAndView= new ModelAndView("contract/view");
        Contract contract=contractService.findById(id);
        if(contract!=null){
            modelAndView.add
        }

        return modelAndView;
    }
*/
}
