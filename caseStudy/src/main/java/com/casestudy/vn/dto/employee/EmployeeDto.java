package com.casestudy.vn.dto.employee;

import com.casestudy.vn.model.employee.Division;
import com.casestudy.vn.model.employee.EducationDegree;
import com.casestudy.vn.model.employee.Position;
import com.casestudy.vn.model.employee.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class EmployeeDto implements Validator {
    private Integer employeeId;
    @NotNull
    @NotBlank
    private String employeeName;
    @NotNull
    private Date employeeBirthday;
    @NotNull
    @Pattern(regexp="[0-9]{9}",message = "dài tối thiểu 9 số")
    private String employeeIdCard;
    private String employeeSalary;
    @NotNull
    @NotBlank
    private String employeePhone;
    @Email
    private String employeeEmail;
    private String employeeAddress;
    @NotNull(message = "Vị trí không được để trống!")
    private Position position;
    @NotNull(message = "Bằng đại học không được để trống!")
    private EducationDegree educationDegree;
    @NotNull(message="Phân chia khu không được để trống!")
    private Division division;
    private User user;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
    EmployeeDto employeeDto=(EmployeeDto) target;
    }
}
