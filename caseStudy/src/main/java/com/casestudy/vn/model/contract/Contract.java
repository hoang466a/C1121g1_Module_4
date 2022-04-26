package com.casestudy.vn.model.contract;

import com.casestudy.vn.model.customer.Customer;
import com.casestudy.vn.model.employee.Employee;
import com.casestudy.vn.model.service_furama.Service;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contractId;
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private Date contractStartDate;
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private Date contractEndDate;
    @Column(columnDefinition = "Decimal(10,2)")
    private String contractTotalMoney;
    @Column(columnDefinition = "Decimal(10,2)")
    private String contractDeposit;
    @ManyToOne
    @JoinColumn(name="employee_id",referencedColumnName = "employeeId")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name="customer_id",referencedColumnName = "customerId")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name="service_id",referencedColumnName = "serviceId")
    private Service service;
    @OneToMany(mappedBy = "contract",cascade = CascadeType.ALL)
    private Set<ContractDetail> contractDetailSet;

    public Contract() {
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
}
