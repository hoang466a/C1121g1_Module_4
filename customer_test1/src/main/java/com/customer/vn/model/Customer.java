package com.customer.vn.model;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer {
    @Id
    private Integer idCustomer;
    private String nameCustomer;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private Set<PassBook> passBook;

    public Customer() {
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
}
