package com.codegym.blog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IGeneralService<T> {

    List<T> findAll();

    Page<T> findAllPage(Pageable pageable);

    T findById(Integer id);

    void save(T t);

    void remove(Integer id);

}
