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
import java.time.LocalDate;

public class PassBookDTO implements Validator {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPassBook;
    @NotBlank
    private String depositDate;
    @NotNull
    @Pattern(regexp = "^[0-9]*$")
    private String money;
    @NotNull
    @Valid
    private CustomerDTO customer;
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

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
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
        PassBookDTO passBookDTO = (PassBookDTO) target;
        Integer yearPast=Integer.parseInt(passBookDTO.depositDate.substring(0,4));
        Integer yearCurrent= LocalDate.now().getYear();
        if(yearCurrent-yearPast<0){
            errors.rejectValue("depositDate","std.not0","Ng??y nh???p kh??ng ???????c nh??? h??n ng??y hi???n t???i!");
        }
        else if (!passBookDTO.money.matches("^[0-9]+$")) {
            errors.rejectValue("money", "Format", "?????nh d???ng kh??ng h???p l???");
        } else if (passBookDTO.money == "" || Long.parseLong(passBookDTO.money) < 30000000) {
            errors.rejectValue("money", "not enough money", "S??? ti???n nh???p " +
                    "ph???i l???n h??n ho???c b???ng 30000000");
        }
    }
}
