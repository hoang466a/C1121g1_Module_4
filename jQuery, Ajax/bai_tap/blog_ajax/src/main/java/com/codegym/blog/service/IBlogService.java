package com.codegym.blog.service;

import com.codegym.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService extends IGeneralService<Blog> {
    Page<Blog> findAllPaging(String keyword, Pageable pageable);
    Page<Blog> findAllByCateId(Integer id,Pageable pageable);
}
