package com.huyhoang.demo.repository;

import com.huyhoang.demo.model.Blog;
import com.huyhoang.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {
    Page<Blog> findByNameCategoryContaining(String name, Pageable pageable);
}
