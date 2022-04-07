package com.hoang.vn.service.impl;

import com.hoang.vn.model.User;
import com.hoang.vn.repository.UserRepository;
import com.hoang.vn.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public Page<User> findAllPaging(String name, Pageable pageable) {
        return userRepository.findAllByFirstNameContaining(name,pageable);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }
}
