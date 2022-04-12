package com.codegym.vn.model;


import javax.persistence.*;

@Entity
public class LibraryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCard;
    private String codeCard;

    @ManyToOne
    @JoinColumn(name="id_book",referencedColumnName = "idBook")
    private Book bookOB;

    public LibraryCard() {
    }

    public LibraryCard(Integer idCard, String codeCard, Book bookOB) {
        this.idCard = idCard;
        this.codeCard = codeCard;
        this.bookOB = bookOB;
    }

    public Integer getIdCard() {
        return idCard;
    }

    public void setIdCard(Integer idCard) {
        this.idCard = idCard;
    }

    public String getCodeCard() {
        return codeCard;
    }

    public void setCodeCard(String codeCard) {
        this.codeCard = codeCard;
    }

    public Book getBook() {
        return bookOB;
    }

    public void setBook(Book book) {
        this.bookOB = book;
    }
}
