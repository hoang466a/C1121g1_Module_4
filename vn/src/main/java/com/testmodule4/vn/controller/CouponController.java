package com.testmodule4.vn.controller;

import com.testmodule4.vn.dto.dtocoupon.CouponDto;
import com.testmodule4.vn.model.Coupon;
import com.testmodule4.vn.service.ICouponService;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class CouponController {
    @Autowired
    ICouponService couponService;


    @GetMapping("/coupon")
    public ModelAndView showList(@PageableDefault(value = 3, sort = "id", direction = Sort.Direction.ASC)
                                         Pageable pageable, @RequestParam(value = "keyword", required = false) Optional<String> keyword,
                                 @RequestParam(value = "startdate", defaultValue = "1900-01-01", required = false) String startDate,
                                 @RequestParam(value = "enddate", defaultValue = "2500-01-01", required = false) String enddate) throws ParseException {
        String keyWordValue = keyword.orElse("");
        ModelAndView modelAndView = new ModelAndView("coupon/list");
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
        Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(enddate);
        // Page<Coupon> couponList = couponService.searchAllPage(keyWordValue, pageable);
        Page<Coupon> couponList = couponService.searchAllPage2(keyWordValue, date1, date2, pageable);
        modelAndView.addObject("couponList", couponList);
        modelAndView.addObject("keyWordValue", keyWordValue);
        return modelAndView;
    }


    @GetMapping("/coupon/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("coupon/create");
        CouponDto couponDto = new CouponDto();
        modelAndView.addObject("couponDto", couponDto);
        return modelAndView;
    }

    @PostMapping("/coupon/save")
    public ModelAndView saveCoupon(@Valid @ModelAttribute CouponDto couponDto,
                                   BindingResult bindingResult) {
        couponDto.validate(couponDto, bindingResult);
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("coupon/create");
            return modelAndView;
        } else {
            Coupon coupon = new Coupon();
            ModelAndView modelAndView = new ModelAndView("redirect:/coupon");
            BeanUtils.copyProperties(couponDto, coupon);
            couponService.save(coupon);
            return modelAndView;
        }
    }

    @PostMapping("/remove")
    public ModelAndView delete(@RequestParam Integer idDelete) {
        ModelAndView modelAndView = new ModelAndView("redirect:/coupon");
        couponService.remove(idDelete);
        return modelAndView;
    }



    /*@GetMapping("/employee/{id}/edit")
    public ModelAndView showEdit(@PathVariable int id){
        ModelAndView modelAndView=new ModelAndView("employee/edit");
        EmployeeDto employeeDto=new EmployeeDto();
        BeanUtils.copyProperties(employeeService.findById(id),employeeDto);
        modelAndView.addObject("positionList",positionService.findAll());
        modelAndView.addObject("educationDegreeList",educationDegreeService.findAll());
        modelAndView.addObject("divivsionList",divisionService.findAll());
        modelAndView.addObject("employeeDto",employeeDto);
        return modelAndView;
    }*/

    /*@PostMapping("/employee/fix")
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
    }*/
}
