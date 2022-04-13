package com.codegym.vn.service.impl;

import com.codegym.vn.model.Product;
import com.codegym.vn.repository.IProductRepository;
import com.codegym.vn.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository productRepository;

    @Override
    public List<Product> showAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {return productRepository.findById(id);}

    public Product findById2(Long id){return productRepository.findById(id).orElse(null);}

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }
}
