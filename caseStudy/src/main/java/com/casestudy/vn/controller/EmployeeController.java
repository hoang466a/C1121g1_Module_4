package com.casestudy.vn.controller;

import com.casestudy.vn.dto.contract.ContractDto;
import com.casestudy.vn.dto.employee.EmployeeDto;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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
    public ModelAndView showList(@PageableDefault(value = 3, sort = "employeeId", direction = Sort.Direction.ASC)
                                         Pageable pageable, @RequestParam Optional<String> keyword) {
        String keyWordValue = keyword.orElse("");
        ModelAndView modelAndView = new ModelAndView("employee/list");
        Page<Employee> employeeList = employeeService.searchAllPage(keyWordValue, pageable);
        modelAndView.addObject("employeeList", employeeList);
        modelAndView.addObject("keyWordValue", keyWordValue);
        return modelAndView;
    }

    @GetMapping("/employee/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("employee/create");
        EmployeeDto employeeDto = new EmployeeDto();
        modelAndView.addObject("positionList", positionService.findAll());
        modelAndView.addObject("educationDegreeList", educationDegreeService.findAll());
        modelAndView.addObject("divivsionList", divisionService.findAll());
        modelAndView.addObject("employeeDto", employeeDto);
        return modelAndView;
    }

    @PostMapping("/employee/save")
    public ModelAndView saveEmployee(@Valid @ModelAttribute EmployeeDto employeeDto,
                                     BindingResult bindingResult) {
        employeeDto.validate(employeeDto, bindingResult);
        employeeDto.setContractSet(null);
        employeeDto.setUser(null);
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("employee/create");
            modelAndView.addObject("positionList", positionService.findAll());
            modelAndView.addObject("educationDegreeList", educationDegreeService.findAll());
            modelAndView.addObject("divivsionList", divisionService.findAll());
            return modelAndView;
        } else {
            Employee employee = new Employee();
            ModelAndView modelAndView = new ModelAndView("redirect:/employee");
            BeanUtils.copyProperties(employeeDto, employee);
            employeeService.save(employee);
            return modelAndView;
        }
    }


    @GetMapping("/employee/{id}/edit")
    public ModelAndView showEdit(@PathVariable int id){
        ModelAndView modelAndView=new ModelAndView("employee/edit");
        EmployeeDto employeeDto=new EmployeeDto();
        BeanUtils.copyProperties(employeeService.findById(id),employeeDto);
        modelAndView.addObject("positionList",positionService.findAll());
        modelAndView.addObject("educationDegreeList",educationDegreeService.findAll());
        modelAndView.addObject("divivsionList",divisionService.findAll());
        modelAndView.addObject("employeeDto",employeeDto);
        return modelAndView;
    }

    @PostMapping("/employee/fix")
    public ModelAndView changeEmployee(@Valid @ModelAttribute EmployeeDto employeeDto,
                                     BindingResult bindingResult) {
        employeeDto.validate(employeeDto, bindingResult);
        if(employeeDto.getUser().equals("")){employeeDto.setUser(null);}
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("employee/edit");
            modelAndView.addObject("positionList", positionService.findAll());
            modelAndView.addObject("educationDegreeList", educationDegreeService.findAll());
            modelAndView.addObject("divivsionList", divisionService.findAll());
            return modelAndView;
        } else {
            Employee employee = new Employee();
            ModelAndView modelAndView = new ModelAndView("redirect:/employee");
            BeanUtils.copyProperties(employeeDto, employee);
            employeeService.save(employee);
            return modelAndView;
        }
    }



}
