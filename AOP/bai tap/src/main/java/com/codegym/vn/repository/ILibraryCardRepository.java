package com.codegym.vn.repository;

import com.codegym.vn.model.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILibraryCardRepository extends JpaRepository<LibraryCard,Integer> {
}
