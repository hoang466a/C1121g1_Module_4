package com.huyhoang.demo.repository;

import com.huyhoang.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    Page<Blog> findByNameBlogContaining(String name, Pageable pageable);
}
