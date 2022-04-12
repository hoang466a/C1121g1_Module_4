package com.codegym.vn.service.impl;

import com.codegym.vn.model.LibraryCard;
import com.codegym.vn.repository.ILibraryCardRepository;
import com.codegym.vn.service.ILibraryCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class LibraryCardService implements ILibraryCardService {

    @Override
    public List<LibraryCard> findAll() {
        return null;
    }

    @Override
    public Page<LibraryCard> searchAllPage(Optional<String> name, Pageable pageable) {
        return null;
    }

    @Override
    public LibraryCard findById(Integer id) {
        return null;
    }

    @Override
    public void save(LibraryCard libraryCard) {

    }

    @Override
    public void remove(Integer id) {

    }
}
