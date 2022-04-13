package com.codegym.vn.service;

import com.codegym.vn.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product>showAll();
    Optional<Product> findById(Long id);
    void save(Product product);
    Product findById2(Long id);
}
