package com.codegym.vn.controller;

import com.codegym.vn.service.impl.BookService;
import com.codegym.vn.service.impl.LibraryCardService;
import org.springframework.beans.factory.annotation.Autowired;

public class BookController {
    @Autowired
    BookService bookService;

    @Autowired
    LibraryCardService libraryCardService;
}
