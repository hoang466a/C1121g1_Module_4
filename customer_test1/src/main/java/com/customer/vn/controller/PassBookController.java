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
                                 @RequestParam(name="keyword",required = false) Optional<String> keyword,
                                 @RequestParam(name="keyword2",required = false) Optional<String> keyword2,
                                 @RequestParam(name="keyword3",required = false) Optional<String> keyword3){
        String keywordValue=keyword.orElse("");
        String keywordValue2=keyword2.orElse("");
        String keywordValue3=keyword3.orElse("");

        ModelAndView modelAndView=new ModelAndView("passbook/list");
//keyword.isPresent();
//keyword.get().equals("");
        if(keyword.isPresent()&&keyword2.isPresent()
                &&keyword3.isPresent()) {
            Page<PassBook> passBookList=passBookService.findAll(pageable);
            modelAndView.addObject("passBookList",passBookList);
        } else {
            Page<PassBook> passBookList=passBookService.findAll2(keyword2,
                    keyword3,keyword,pageable);
            modelAndView.addObject("passBookList",passBookList);
        }

        List<Customer> customerList=customerService.findAll();
        List<Tenor> tenorList=tenorService.findAll();
        modelAndView.addObject("customerList",customerList);
        modelAndView.addObject("tenorList",tenorList);
        modelAndView.addObject("keywordValue",keywordValue);
        modelAndView.addObject("keywordValue2",keywordValue2);
        modelAndView.addObject("keywordValue3",keywordValue3);
        return modelAndView;
    }

    @GetMapping("/passbook/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView=new ModelAndView("/passbook/create");
        PassBookDTO passBookDTO=new PassBookDTO();
        List<Tenor> tenorList=tenorService.findAll();
        modelAndView.addObject("passBookDTO",passBookDTO);
        modelAndView.addObject("tenorList",tenorList);
        return modelAndView;
    }

   @PostMapping("/passbook/savePassBook")
    public ModelAndView savePassBook(@Valid @ModelAttribute PassBookDTO passBookDTO
            , BindingResult bindingResult){

        passBookDTO.validate(passBookDTO,bindingResult);

        if(bindingResult.hasFieldErrors()){
            ModelAndView modelAndView=new ModelAndView( "/passbook/create");
            modelAndView.addObject("tenorList",tenorService.findAll());
            return modelAndView;
        }
        else {
            PassBook passBook = new PassBook();
            ModelAndView modelAndView=new ModelAndView("redirect:/passbook/list");
            BeanUtils.copyProperties(passBookDTO,passBook);
            passBook.setCustomer(new Customer());
            BeanUtils.copyProperties(passBookDTO.getCustomer(),passBook.getCustomer());
            passBookService.save(passBook);
            return modelAndView;
        }
    }

    @GetMapping("passbook/{id}/view")
    public ModelAndView viewCustomer(@PathVariable int id){
        ModelAndView modelAndView=new ModelAndView("/passbook/view");
        PassBook passBook=passBookService.findById(id);
        modelAndView.addObject("passBook",passBook);
        return modelAndView;
    }

    @GetMapping("/passbook/{id}/delete")
    public ModelAndView deletePassbook(@PathVariable int id){
        passBookService.remove(id);
        ModelAndView modelAndView=new ModelAndView("redirect:/passbook/list");
        return modelAndView;
    }


    @GetMapping("passbook/{id}/edit")
    public ModelAndView editPassbook(@PathVariable int id){
        ModelAndView modelAndView=new ModelAndView("passbook/edit");
        PassBookDTO passBookDTO=new PassBookDTO();
        CustomerDTO customerDTO=new CustomerDTO();
        PassBook passBook=passBookService.findById(id);
        Customer customer=customerService.findById(passBook.getCustomer().getIdCustomer());
        List<Tenor> tenorList=tenorService.findAll();
        BeanUtils.copyProperties(customer,customerDTO);
        BeanUtils.copyProperties(passBook,passBookDTO);
        passBookDTO.setCustomer(customerDTO);
        modelAndView.addObject("passBookDTO",passBookDTO);
        modelAndView.addObject("tenorList",tenorList);
        return modelAndView;
    }



    @PostMapping("passbook/update")
    public ModelAndView editAndSavePassBook(@Valid @ModelAttribute PassBookDTO passBookDTO,
                                            BindingResult bindingResult){
        passBookDTO.validate(passBookDTO,bindingResult);

        if(bindingResult.hasFieldErrors()){
            ModelAndView modelAndView=new ModelAndView( "/passbook/edit");
            modelAndView.addObject("tenorList",tenorService.findAll());
            return modelAndView;
        }
        else {
            PassBook passBook = new PassBook();
            ModelAndView modelAndView=new ModelAndView("redirect:/passbook/list");
            BeanUtils.copyProperties(passBookDTO,passBook);
            passBook.setCustomer(new Customer());
            BeanUtils.copyProperties(passBookDTO.getCustomer(),passBook.getCustomer());
            passBookService.save(passBook);
            return modelAndView;
        }
    }





}
