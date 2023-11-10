package com.nyy.bookstore.services;

import com.nyy.bookstore.entity.Book;
import com.nyy.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getBookList()
    {
        return bookRepository.findAll();
    }

    public String addBook(Book bookModel)
    {
        String bookName = bookModel.getBookTitle();


       if(checkBookExists(bookName))
       {
           return "Book Already in Store, Pls double check in Store again";
       }
       Book book =  bookRepository.save(bookModel);

       if(book!=null)
       {
            return "Success Added New Book to Store";
       }

       return "Book not added to store!";
    }


    protected boolean checkBookExists(String bookName)
    {
        return bookRepository.findByBookTitle(bookName) != null;
    }

}
