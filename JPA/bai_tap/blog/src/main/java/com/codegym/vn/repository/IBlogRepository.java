package com.codegym.vn.repository;

import com.codegym.vn.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    List<Blog>findAllByName(String name);
}
