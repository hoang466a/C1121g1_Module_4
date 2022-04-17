package com.codegym.vn.controller;


import com.codegym.vn.dto.SmartPhoneDTO;
import com.codegym.vn.model.SmartPhone;
import com.codegym.vn.service.impl.SmartPhoneService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class SmartPhoneController {
    @Autowired
    SmartPhoneService smartPhoneService;

    @GetMapping("/smartphone/list")
    public ResponseEntity<Page<SmartPhone>>showList(@PageableDefault
                                                                (value=2,sort="id",direction = Sort.Direction.ASC)Pageable pageable,
                                                    @RequestParam Optional<String>keyword){
        String keywordvalue=keyword.orElse("");
        Page<SmartPhone> smartPhoneList=smartPhoneService.showAll(keywordvalue,pageable);
        return new ResponseEntity<>(smartPhoneList, HttpStatus.OK);
    }

    @GetMapping("/smartphone/list")
    public ModelAndView showAll(@PageableDefault
                                            (value=2,sort="id",direction = Sort.Direction.ASC)Pageable pageable,
                                @RequestParam Optional<String>keyword){
        ModelAndView modelAndView=new ModelAndView("/smartphone/list");
        modelAndView.addObject("smartPhoneList",smartPhoneService.findAll());
        return modelAndView;
    }

    @PostMapping("/smartphone/create")
    public ResponseEntity<Void> createPhone(@RequestBody SmartPhoneDTO smartPhoneDTO){
        SmartPhone smartPhone=new SmartPhone();
        BeanUtils.copyProperties(smartPhoneDTO,smartPhone);
        smartPhoneService.save(smartPhone);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping("/smartphone/{id}")
    public ResponseEntity<SmartPhone> editPhone(@PathVariable Long id,@RequestBody SmartPhoneDTO smartPhoneDTO) {
        SmartPhone smartPhone=smartPhoneService.findById(id);
        if(smartPhone==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        smartPhoneDTO.setId(smartPhone.getId());
        BeanUtils.copyProperties(smartPhoneDTO,smartPhone);
        smartPhoneService.save(smartPhone);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/smartphone/{id}")
    public ResponseEntity<SmartPhone> deletePhone(@PathVariable Long id){
        SmartPhone smartPhone=smartPhoneService.findById(id);
        if(smartPhone==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        smartPhoneService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
