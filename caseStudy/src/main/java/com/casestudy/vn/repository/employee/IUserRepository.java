package com.casestudy.vn.repository.employee;

import com.casestudy.vn.model.employee.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,String> {
}
