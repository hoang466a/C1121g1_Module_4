package com.codegym.blog.repository;

import com.codegym.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    Page<Blog> findByNameBlogContaining(String name, Pageable pageable);

    @Query("select u from blog u where u.categoryOb.idCategory=?1")
    Page<Blog> findByIdCategory(Integer id,Pageable pageable);
}
