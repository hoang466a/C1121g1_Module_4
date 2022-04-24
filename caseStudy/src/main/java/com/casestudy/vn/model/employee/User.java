package com.casestudy.vn.model.employee;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    private String username;
    private String password;

    public User() {
    }

    @JsonBackReference
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<Employee> employeeSet;

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
