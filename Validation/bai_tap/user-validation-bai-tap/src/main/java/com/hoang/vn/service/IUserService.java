package com.hoang.vn.service;

import com.hoang.vn.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    void save(User user);
    User findById(int id);
    void deleteById(int id);
    Page<User> findAllPaging(String name,Pageable pageable);
    void delete(User user);
}
