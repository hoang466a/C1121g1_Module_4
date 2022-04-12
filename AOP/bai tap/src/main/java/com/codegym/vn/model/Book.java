package com.codegym.vn.model;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBook;
    private String nameBook;
    private String author;
    private String value;

    public Book() {
    }

    @OneToMany(mappedBy = "bookOB",cascade = CascadeType.ALL)
    Set<LibraryCard> libraryCard;

    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Set<LibraryCard> getLibraryCard() {
        return libraryCard;
    }

    public void setLibraryCard(Set<LibraryCard> libraryCard) {
        this.libraryCard = libraryCard;
    }
}
