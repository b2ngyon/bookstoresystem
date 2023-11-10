package com.nyy.bookstore.controller;

import com.nyy.bookstore.entity.Book;
import com.nyy.bookstore.repository.BookRepository;
import com.nyy.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/book")
public class BookController {

    @Autowired
    BookService bookService;

    @CrossOrigin
    @GetMapping(path="/getBookList")
    public List<Book> getAllBookInStore()
    {
        return bookService.getBookList();
    }

    @CrossOrigin
    @PostMapping(path="/addBook")
    public String addBooktoStore(@RequestBody Book book)
    {
        return bookService.addBook(book);
    }
}
