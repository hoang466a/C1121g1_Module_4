package com.huyhoang.demo.service;

import com.huyhoang.demo.model.Blog;
import com.huyhoang.demo.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService extends IGeneralService<Blog> {
    Page<Blog> findAllPaging(String keyword, Pageable pageable);
}
