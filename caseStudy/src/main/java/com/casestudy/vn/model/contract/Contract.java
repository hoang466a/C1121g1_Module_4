package com.casestudy.vn.model.contract;

import com.casestudy.vn.model.customer.Customer;
import com.casestudy.vn.model.employee.Employee;
import com.casestudy.vn.model.service_furama.Service;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contractId;
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private Date contractStartDate;
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private Date contractEndDate;
    private String contractDeposit;
    private String contractTotalMoney;
    @ManyToOne
    @JoinColumn(name="employee_id",referencedColumnName = "employeeId")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name="customer_id",referencedColumnName = "customerId")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name="service_id",referencedColumnName = "serviceId")
    private Service Service;

}
