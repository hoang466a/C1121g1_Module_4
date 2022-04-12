package com.codegym.vn.repository;

import com.codegym.vn.model.Book;
import com.codegym.vn.model.LibraryCard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IBookRepository extends JpaRepository<Book,Integer> {
    @Query(value="select u from Book u where u.nameBook like ?1 order by u.idBook")
    Page<Book> findAllByName(String name, Pageable pageable);


   // Page<Book> findAllByNameBookContaining(String name2,Pageable pageable);
}
