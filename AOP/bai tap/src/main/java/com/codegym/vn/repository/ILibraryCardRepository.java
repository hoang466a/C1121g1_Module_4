package com.codegym.vn.repository;

import com.codegym.vn.model.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ILibraryCardRepository extends JpaRepository<LibraryCard,Integer> {
    @Query(value="select u from LibraryCard u where u.codeCard=?1")
    public LibraryCard findByCode(String code);
}
