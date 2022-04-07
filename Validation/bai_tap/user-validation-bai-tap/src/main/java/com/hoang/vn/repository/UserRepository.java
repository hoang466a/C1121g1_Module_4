package com.hoang.vn.repository;

import com.hoang.vn.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.web.PageableDefault;

public interface UserRepository extends JpaRepository<User,Integer> {
    public Page<User> findAllByFirstNameContaining(String name, Pageable pageable);
}
