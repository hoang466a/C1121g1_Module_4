package com.customer.vn.dto;

import com.customer.vn.model.Customer;
import com.customer.vn.model.Tenor;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class PassBookDTO implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPassBook;
    @NotBlank
    private String depositDate;
    @NotNull
    @Pattern(regexp = "^[0-9]*$")
    private String money;
    @NotNull
    @Valid
    private Customer customer;
    @NotNull
    private Tenor tenor;

    public PassBookDTO() {
    }

    public Integer getIdPassBook() {
        return idPassBook;
    }

    public void setIdPassBook(Integer idPassBook) {
        this.idPassBook = idPassBook;
    }

    public String getDepositDate() {
        return depositDate;
    }

    public void setDepositDate(String depositDate) {
        this.depositDate = depositDate;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Tenor getTenor() {
        return tenor;
    }

    public void setTenor(Tenor tenor) {
        this.tenor = tenor;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        PassBookDTO passBookDTO=(PassBookDTO) target;
        Long moneyLong=Long.parseLong(passBookDTO.money);
        if(moneyLong<30000000){
            errors.rejectValue("money","not enough money", "Số tiền nhập " +
                    "phải lớn hơn hoặc bằng 30000000");
        }
    }
}
