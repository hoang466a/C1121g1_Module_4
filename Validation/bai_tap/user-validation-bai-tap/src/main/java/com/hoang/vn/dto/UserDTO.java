package com.hoang.vn.dto;


import com.sun.istack.NotNull;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class UserDTO implements Validator {

    private Integer idUser;
    @NotBlank(message = "Không được để trống!")
    @Size(min=5,max=45)
    private String firstName;
    @NotBlank(message = "Không được để trống!")
    @Size(min=5,max=45)
    private String lastName;
    private String phoneNumber;
    private String dateOfBirth;
    @Email(message = "Không đúng định dạng email, xin nhập lại!")
    private String email;

    public UserDTO() {
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO userDTO=(UserDTO)target;
        Integer yearPast=Integer.parseInt(userDTO.dateOfBirth.substring(0,4));
        Integer yearCurrent= LocalDate.now().getYear();
        if(yearCurrent-yearPast<18){
            errors.rejectValue("dateOfBirth","std.not18","Dưới 18 tuổi, không hợp lệ!");
        }
    }
}
