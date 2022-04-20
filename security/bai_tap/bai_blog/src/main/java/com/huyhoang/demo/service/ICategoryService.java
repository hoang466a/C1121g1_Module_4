package com.huyhoang.demo.service;

import com.huyhoang.demo.model.Blog;
import com.huyhoang.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryService extends IGeneralService<Category>{
    Page<Category> findAllPaging(String keyword, Pageable pageable);
}
