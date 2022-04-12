package com.customer.vn.service.Impl;

import com.customer.vn.model.PassBook;
import com.customer.vn.repository.IPassBookRepository;
import com.customer.vn.service.IPassBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PassBookService implements IPassBookService {
    @Autowired
    IPassBookRepository passBookRepository;

    @Override
    public List<PassBook> findAll() {
        return passBookRepository.findAll();
    }

    @Override
    public Page<PassBook> findAllPage(Pageable pageable) {
        return passBookRepository.findAll(pageable);
    }

    @Override
    public PassBook findById(Integer id) {
        return passBookRepository.findById(id).orElse(null);
    }

    @Override
    public void save(PassBook passBook) {
        passBookRepository.save(passBook);
    }

    @Override
    public void remove(Integer id) {
        passBookRepository.deleteById(id);
    }

    @Override
    public Page<PassBook> findAllPaging(String name, Pageable pageable) {
        return null;
    }

    public Page<PassBook> findAll(Pageable pageable) {
        return passBookRepository.findAll(pageable);
    }

    public Page<PassBook> findAll2(Optional<String> date, Optional<String> date2, Optional<String> name, Pageable pageable){
        return passBookRepository.findAllBetWeen2Days(date,date2,name,pageable);
    }
}
