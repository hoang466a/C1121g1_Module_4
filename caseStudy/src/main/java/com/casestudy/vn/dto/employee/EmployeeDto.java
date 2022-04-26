package com.casestudy.vn.dto.employee;

import com.casestudy.vn.model.contract.Contract;
import com.casestudy.vn.model.employee.Division;
import com.casestudy.vn.model.employee.EducationDegree;
import com.casestudy.vn.model.employee.Position;
import com.casestudy.vn.model.employee.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.Set;

public class EmployeeDto implements Validator {
    private Integer employeeId;
    @NotBlank
    private String employeeName;
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private Date employeeBirthday;
    @NotBlank
    @Pattern(regexp="^[0-9]{9}$",message = "chứng minh thư phải dài tối thiểu 9 số")
    private String employeeIdCard;
    @NotBlank
    private String employeeSalary;
    @NotBlank
    @Pattern(regexp="(84|0)+(9[0|1])+([0-9]{7})\\b",message = "dài tối thiểu 10 chữ số")
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
    private Set<Contract> contractSet;

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }

    public EmployeeDto() {
    }


    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(Date employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public String getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(String employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }




    @Override
    public void validate(Object target, Errors errors) {
    EmployeeDto employeeDto=(EmployeeDto) target;
        if (employeeDto.employeeSalary.trim().isEmpty()) {
        } else {
            if (!employeeDto.employeeSalary.matches("^(-?)(0|([1-9][0-9]*))(\\.[0-9]+)?$")) {
                errors.rejectValue("employeeSalary",
                        "std.type", "Định dạng nhập vào không hợp lệ!");
            } else if (Double.parseDouble(employeeDto.employeeSalary) < 0) {
                errors.rejectValue("employeeSalary",
                        "std.number", "Số không được âm, xin nhập lại!");
            }
        }


    }
}
