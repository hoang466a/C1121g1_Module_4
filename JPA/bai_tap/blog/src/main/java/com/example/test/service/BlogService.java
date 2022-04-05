package com.example.test.service;

import com.example.test.model.Blog;
import com.example.test.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository blogRepository;


    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public List<Blog> searchByName(String name) {
        return blogRepository.findAllByName(name);
    }

    @Override
    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public Blog findOne(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }



    @Override
    public boolean exists(int id) {
        return false;
    }

    @Override
    public void delete(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public void delete(Blog blog) {
        blogRepository.delete(blog);
    }
}
