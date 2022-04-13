package com.codegym.vn.controller;

import com.codegym.vn.model.Book;
import com.codegym.vn.model.LibraryCard;
import com.codegym.vn.service.impl.BookService;
import com.codegym.vn.service.impl.LibraryCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @Autowired
    LibraryCardService libraryCardService;

    @GetMapping("/book/list")
    public ModelAndView showAll(@PageableDefault
                                            (value=3,sort = "idBook",direction = Sort.Direction.ASC)
                                            Pageable pageable,
                                            @RequestParam(name="keyword") Optional<String> keywordValue){
        String keywordValue1=keywordValue.orElse("");
        ModelAndView modelAndView=new ModelAndView("book/list");
        Page<Book> bookList=bookService.searchAllPage(keywordValue1,pageable);
        modelAndView.addObject("bookList",bookList);
        modelAndView.addObject("keywordValue",keywordValue1);
        return modelAndView;
    }

    @GetMapping("/book/{id}/borrow")
    public ModelAndView showBorrow(@PathVariable int id){
        ModelAndView modelAndView=new ModelAndView("book/borrow");
        Book book=bookService.findById(id);
        modelAndView.addObject("book",book);
        return modelAndView;
    }

    @PostMapping("/book/borrowBook")
    public String borrowBook(@ModelAttribute("book")Book book, RedirectAttributes redirectAttributes){
        String random=random();
        LibraryCard libraryCard=new LibraryCard(null,random,book);
        int value=Integer.parseInt(book.getValue());
        if((value-1)<0) {
            return("book/error"); }
        else{
            String value2=String.valueOf(value-1);
            book.setValue(value2);
            bookService.save(book);
            libraryCardService.save(libraryCard);
            redirectAttributes.addFlashAttribute("code",random);
            redirectAttributes.addFlashAttribute("nameBook",book.getNameBook());
            redirectAttributes.addFlashAttribute("idBook",book.getIdBook());
            return ("redirect:/book/list");
        }
    }

    @GetMapping("/book/return")
    public ModelAndView showReturnBook(){
        ModelAndView modelAndView=new ModelAndView("book/return");
        LibraryCard libraryCard=new LibraryCard();
        modelAndView.addObject("libraryCard",libraryCard);
        return modelAndView;
    }

    @PostMapping("/book/returnBook")
    public ModelAndView returnBook(@ModelAttribute("libraryCard")LibraryCard libraryCard){
        ModelAndView modelAndView=new ModelAndView();
        LibraryCard libraryCard1=libraryCardService.findByCode(libraryCard.getCodeCard());
        if(libraryCard1==null) {
            modelAndView=new ModelAndView("book/error"); } else{
            if(libraryCard1.getBook().getIdBook()!=libraryCard.getBook().getIdBook()){
                modelAndView=new ModelAndView("book/error"); }
            else{
                libraryCardService.removeCard(libraryCard1);
                Book book=bookService.findById(libraryCard1.getBook().getIdBook());
                Integer value=Integer.parseInt(book.getValue());
                String value2=String.valueOf(value+1);
                book.setValue(value2);
                bookService.save(book);
                modelAndView=new ModelAndView("redirect:/book/list");
            }
        }
        return modelAndView;}




    public String random(){
        double randomDouble = Math.random();
        randomDouble = randomDouble * 5 + 1;
        Long test=(long)((randomDouble*Math.pow(10,16))%Math.pow(10,5));
        return test.toString();
    }



}
