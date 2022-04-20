package com.huyhoang.demo.repository;

import com.huyhoang.demo.model.entity.AppRole;
import com.huyhoang.demo.model.entity.AppUser;
import com.huyhoang.demo.model.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRoleRepository extends JpaRepository<UserRole,Long> {
        List<UserRole>findAllByAppUser(AppUser appUser);
}
