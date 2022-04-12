package com.codegym.vn.dto;

import com.codegym.vn.model.LibraryCard;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
import java.util.Set;

public class BookDTO implements Validator {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBook;
    @NotBlank
    private String nameBook;
    @NotBlank
    private String author;
    @NotBlank
    private String value;

    Set<LibraryCard> libraryCard;

    public BookDTO() {
    }

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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        BookDTO bookDTO=(BookDTO) target;
        if(!bookDTO.value.matches("^[0-9]+$")){
            errors.rejectValue("value", "Format", "Định dạng không hợp lệ");
        }
    }
}
