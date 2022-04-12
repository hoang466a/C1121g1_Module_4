package com.codegym.vn.repository;

import com.codegym.vn.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IBookRepository extends JpaRepository<Book,Integer> {
    @Query(value="select u from Book u where u.nameBook=?1 order by u.idBook")
    Page<Book> findAllbyName(Optional<String> name, Pageable pageable);
}
