package com.codegym.blog.service;

import com.codegym.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryService extends IGeneralService<Category> {
    Page<Category> findAllPaging(String keyword, Pageable pageable);
}
