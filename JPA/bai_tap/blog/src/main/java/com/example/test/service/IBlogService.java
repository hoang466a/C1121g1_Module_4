package com.example.test.service;

import com.example.test.model.Blog;

import java.util.List;

public interface IBlogService {
    Blog findById(int id);
    List<Blog> findAll();
    List<Blog> searchByName(String name);
    Blog save (Blog blog);
    Blog findOne(Integer id);
    boolean exists(int id);
    void delete(int id);
    void delete(Blog blog);
}
