package com.codegym.vn.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {

    List<T> findAll();

    Page<T> searchAllPage(Optional<String>name, Pageable pageable);

    T findById(Integer id);

    void save(T t);

    void remove(Integer id);

}
