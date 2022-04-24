package com.casestudy.vn.controller;


import com.casestudy.vn.dto.service_furama.ServiceDTO;
import com.casestudy.vn.model.service_furama.Service;
import com.casestudy.vn.service.service_furama.IRentTypeService;
import com.casestudy.vn.service.service_furama.IServiceService;
import com.casestudy.vn.service.service_furama.IServiceTypeService;
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
import java.util.Optional;


@Controller
public class ServiceController {
    @Autowired
    IServiceService serviceService;

    @Autowired
    IRentTypeService rentTypeService;

    @Autowired
    IServiceTypeService serviceTypeService;


    @GetMapping("/service")
    public ModelAndView showList(@PageableDefault(value=3,sort="serviceId",direction = Sort.Direction.ASC)
                                         Pageable pageable, @RequestParam Optional<String> keyword){
        String keyWordValue= keyword.orElse("");
        ModelAndView modelAndView=new ModelAndView("service_furama/list");
        Page<Service> serviceList=serviceService.searchAllPage(keyWordValue,pageable);
        modelAndView.addObject("serviceList",serviceList);
        modelAndView.addObject("keyWordValue",keyWordValue);
        return modelAndView;
    }

    @GetMapping("/service_furama/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView=new ModelAndView("service_furama/create");
        ServiceDTO serviceDTO=new ServiceDTO();
        modelAndView.addObject("rentTypeList",rentTypeService.findAll());
        modelAndView.addObject("serviceTypeList",serviceTypeService.findAll());
        modelAndView.addObject("serviceDTO",serviceDTO);
        return modelAndView;
    }

    @PostMapping("/service_furama/save")
    public ModelAndView saveService(@Valid @ModelAttribute ServiceDTO serviceDTO,
                                     BindingResult bindingResult){
        serviceDTO.validate(serviceDTO,bindingResult);
        if(bindingResult.hasErrors()){
            ModelAndView modelAndView=new ModelAndView("service_furama/create");
            modelAndView.addObject("rentTypeList",rentTypeService.findAll());
            modelAndView.addObject("serviceTypeList",serviceTypeService.findAll());
            return modelAndView;
        }
        else{
            if (serviceDTO.getServiceArea().trim().isEmpty()) {
                serviceDTO.setServiceArea(null); }
            if (serviceDTO.getServiceMaxPeople().trim().isEmpty()) {
                serviceDTO.setServiceMaxPeople(null); }
            if (serviceDTO.getPoolArea().trim().isEmpty()) {
                serviceDTO.setPoolArea(null); }
            if (serviceDTO.getNumberOfFloor().trim().isEmpty()) {
                serviceDTO.setNumberOfFloor(null); }
            Service service=new Service();
            ModelAndView modelAndView=new ModelAndView("redirect:/service");
            BeanUtils.copyProperties(serviceDTO,service);
            serviceService.save(service);
            return modelAndView;
        }
    }
}
