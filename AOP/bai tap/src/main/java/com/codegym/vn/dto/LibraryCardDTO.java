package com.codegym.vn.dto;

import com.codegym.vn.model.Book;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LibraryCardDTO implements Validator {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCard;
    @NotBlank
    private String codeCard;
    @NotNull
    @Valid
    private BookDTO book;

    public BookDTO getBook() {
        return book;
    }

    public void setBook(BookDTO book) {
        this.book = book;
    }

    public LibraryCardDTO() {
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


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        LibraryCardDTO libraryCardDTO=(LibraryCardDTO)target;
        if(!libraryCardDTO.codeCard.matches("^[0-9]+$")){
            errors.rejectValue("codeCard", "Format", "Định dạng không hợp lệ");
        }
    }
}
