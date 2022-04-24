package com.casestudy.vn.service.employee.impl;

import com.casestudy.vn.model.employee.User;
import com.casestudy.vn.repository.employee.IUserRepository;
import com.casestudy.vn.service.employee.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserRepository userRepository;


    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
