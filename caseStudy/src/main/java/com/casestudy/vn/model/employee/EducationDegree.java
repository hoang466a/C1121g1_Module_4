package com.casestudy.vn.model.employee;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class EducationDegree {
    @Id
    private Integer educationDegreeId;
    private Integer educationDegreeName;

    public EducationDegree() {
    }

    @JsonBackReference
    @OneToMany(mappedBy = "educationDegree",cascade = CascadeType.ALL)
    private Set<Employee> employeeSet;

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }

    public Integer getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(Integer educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public Integer getEducationDegreeName() {
        return educationDegreeName;
    }

    public void setEducationDegreeName(Integer educationDegreeName) {
        this.educationDegreeName = educationDegreeName;
    }
}
