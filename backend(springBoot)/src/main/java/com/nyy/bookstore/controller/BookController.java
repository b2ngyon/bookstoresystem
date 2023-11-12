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
    public String addBooktoStore(@RequestBody Book bookModel)
    {
        return bookService.addBook(bookModel);
    }

    @CrossOrigin
    @PostMapping(path="/updateBook")
    public String updateBookDetail(@RequestBody Book bookModel)
    {
            return bookService.updateBook(bookModel);
    }

    @CrossOrigin
    @PostMapping(path="/deleteBook/{bookId}")
    public String deleteBookById(@RequestParam(name="bookId") int bookId )
    {
        return bookService.deleteBook(bookId);
    }

}
