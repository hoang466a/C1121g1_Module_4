package com.customer.vn.dto;

import com.customer.vn.model.PassBook;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

public class CustomerDTO implements Validator {
    //@NotNull(message = "Không được để trống!")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCustomer;
    //@NotBlank(message = "Nhập vào không hợp lệ!")
    @Pattern(regexp = "[a-zA-Z][a-zA-Z ]{1,}",message = "Nhập vào không hợp lệ")
    private String nameCustomer;
    private Set<PassBook> passBook;

    public CustomerDTO() {
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public Set<PassBook> getPassBook() {
        return passBook;
    }

    public void setPassBook(Set<PassBook> passBook) {
        this.passBook = passBook;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
