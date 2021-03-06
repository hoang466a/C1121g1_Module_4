package com.casestudy.vn.dto.customer;

import com.casestudy.vn.model.contract.Contract;
import com.casestudy.vn.model.customer.Customer;
import com.casestudy.vn.model.customer.CustomerType;
import com.casestudy.vn.service.customer.ICustomerService;
import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.Set;

public class CustomerDTO implements Validator {
    private Integer id;
    @NotBlank
    private String customerName;
    @NotBlank
    @Pattern(regexp="^KH-[0-9]{4}$",message = "Định dạng nhập yêu cầu: KH-XXXX")
    private String customerCode;
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    @NotNull
    private Date customerBirthday;
    private String customerGender;
    @NotBlank(message = "không được để trống")
    @Pattern(regexp="[0-9]{9}",message = "dài tối thiểu 9 số")
    private String customerIdCard;
    @NotBlank(message = "không được để trống")
    @Pattern(regexp="(84|0)+(9[0|1])+([0-9]{7})",message = "dài tối thiểu 10 chữ số")
    private String customerPhone;
    @Email
    private String customerEmail;
    private String customerAddress;
    @NotNull
    private CustomerType customerType;
    private ICustomerService iCustomerService; //để so sánh customerCode có giống nhau hay không?


    public CustomerDTO() {
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public ICustomerService getiCustomerService() {
        return iCustomerService;
    }

    public void setiCustomerService(ICustomerService iCustomerService) {
        this.iCustomerService = iCustomerService;
    }

    private Set<Contract> contractSet;

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(Date customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDTO customerDTO=(CustomerDTO)target;
        String currentCode=customerDTO.getCustomerCode();
        Customer customer=iCustomerService.findByCode(currentCode);
        if(customerDTO.getId()==null){
            if(customer!=null){
                if(customer.getCustomerCode().equals(currentCode)){
                    errors.rejectValue("customerCode", "", "Mã khách hàng đã tồn tại.");
                }
            }
        }



    }
}
