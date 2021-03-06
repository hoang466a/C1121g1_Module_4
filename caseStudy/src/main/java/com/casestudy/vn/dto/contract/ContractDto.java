package com.casestudy.vn.dto.contract;

import com.casestudy.vn.dto.date.DateDto;
import com.casestudy.vn.model.contract.ContractDetail;
import com.casestudy.vn.model.customer.Customer;
import com.casestudy.vn.model.employee.Employee;
import com.casestudy.vn.model.service_furama.Service;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

public class ContractDto implements Validator {
    DateDto dateDto =new DateDto();

    private Integer contractId;
    @NotNull
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private Date contractStartDate;
    @NotNull
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private Date contractEndDate;
    @NotBlank
    private String contractDeposit;
    @NotBlank
    private String contractTotalMoney;
    @NotNull
    private Employee employee;
    @NotNull
    private Customer customer;
    @NotNull
    private Service service;

    private Set<ContractDetail> contractDetailSet;

    public ContractDto() {
    }

    public String getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(String contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Date getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(Date contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public Date getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(Date contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public String getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(String contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public com.casestudy.vn.model.service_furama.Service getService() {
        return service;
    }

    public void setService(com.casestudy.vn.model.service_furama.Service service) {
        this.service = service;
    }

    public Set<ContractDetail> getContractDetailSet() {
        return contractDetailSet;
    }

    public void setContractDetailSet(Set<ContractDetail> contractDetailSet) {
        this.contractDetailSet = contractDetailSet;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDto contractDto= (ContractDto)target;
        if (contractDto.contractDeposit.trim().isEmpty()) {
        } else {
            if (!contractDto.contractDeposit.matches("^(-?)(0|([1-9][0-9]*))(\\.[0-9]+)?$")) {
                errors.rejectValue("contractDeposit",
                        "std.type", "?????nh d???ng nh???p v??o kh??ng h???p l???!");
            } else if (Double.parseDouble(contractDto.contractDeposit) < 0) {
                errors.rejectValue("contractDeposit",
                        "std.number", "S??? kh??ng ???????c ??m, xin nh???p l???i!");
            }
        }

        if (contractDto.contractTotalMoney.trim().isEmpty()) {
        } else {
            if (!contractDto.contractTotalMoney.matches("^(-?)(0|([1-9][0-9]*))(\\.[0-9]+)?$")) {
                errors.rejectValue("contractTotalMoney",
                        "std.type", "?????nh d???ng nh???p v??o kh??ng h???p l???!");
            } else if (Double.parseDouble(contractDto.contractTotalMoney) < 0) {
                errors.rejectValue("contractTotalMoney",
                        "std.number", "S??? kh??ng ???????c ??m, xin nh???p l???i!");
            }
        }

        if(dateDto.compareToToday(contractDto.contractStartDate)==1){
            errors.rejectValue("contractStartDate",
                    "std.startdate", "Ng??y l??m h???p ?????ng kh??ng h???p l???!");
        }
        if(dateDto.compareToToday(contractDto.contractEndDate)==-1){
            errors.rejectValue("contractEndDate",
                    "std.enddate", "Ng??y k???t th??c h???p ?????ng kh??ng h???p l???!");
        }
    }
}
