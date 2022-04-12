package com.codegym.vn.service.impl;

import com.codegym.vn.model.Book;
import com.codegym.vn.repository.IBookRepository;
import com.codegym.vn.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
    IBookRepository iBookRepository;


    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public Page<Book> searchAllPage(String name, Pageable pageable) {
       return iBookRepository.findAllByName("%" + name + "%",pageable);
       // return iBookRepository.findAllByNameBookContaining(name,pageable);
    }

    @Override
    public Book findById(Integer id) {
        return iBookRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Book book) {
        iBookRepository.save(book);
    }

    @Override
    public void remove(Integer id) {
        iBookRepository.deleteById(id);
    }

}
