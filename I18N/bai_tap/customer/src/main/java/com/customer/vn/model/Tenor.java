package com.customer.vn.model;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Tenor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTenor;
    private String nameTenor;

    @OneToMany(mappedBy = "tenor")
    private Set<PassBook> passBook;

    public Tenor() {
    }

    public int getIdTenor() {
        return idTenor;
    }

    public void setIdTenor(int idTenor) {
        this.idTenor = idTenor;
    }

    public String getNameTenor() {
        return nameTenor;
    }

    public void setNameTenor(String nameTenor) {
        this.nameTenor = nameTenor;
    }

    public Set<PassBook> getPassBook() {
        return passBook;
    }

    public void setPassBook(Set<PassBook> passBook) {
        this.passBook = passBook;
    }
}
