package com.huyhoang.demo.repository;

import com.huyhoang.demo.model.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<AppUser,Long> {
    AppUser findByUserName(String username);
}
