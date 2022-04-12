package com.codegym.vn.service.impl;

import com.codegym.vn.model.Book;
import com.codegym.vn.repository.IBookRepository;
import com.codegym.vn.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class BookService implements IBookService {

    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public Page<Book> searchAllPage(Optional<String> name, Pageable pageable) {
        return null;
    }

    @Override
    public Book findById(Integer id) {
        return null;
    }

    @Override
    public void save(Book book) {

    }

    @Override
    public void remove(Integer id) {

    }
}
