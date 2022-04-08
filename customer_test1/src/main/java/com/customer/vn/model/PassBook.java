package com.customer.vn.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name="passbook")
public class PassBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPassBook;
    private String depositDate;
    private String money;

    @ManyToOne
    @JoinColumn(name="id_tenor",referencedColumnName = "idTenor")
    private Tenor tenor;

    @ManyToOne
    @JoinColumn(name="id_customer", referencedColumnName = "idCustomer")
    private Customer customer;

    public PassBook() {
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

    public Tenor getTenor() {
        return tenor;
    }

    public void setTenor(Tenor tenor) {
        this.tenor = tenor;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
