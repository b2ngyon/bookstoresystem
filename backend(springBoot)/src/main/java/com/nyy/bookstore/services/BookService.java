package com.nyy.bookstore.services;

import com.nyy.bookstore.entity.Book;
import com.nyy.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

    public String updateBook(Book bookModel)
    {
        Book getBook = bookRepository.findById(bookModel.getBookId()).get();

        if(getBook==null)
        {
            return "Book not exists, Use Add Book function to added in store";
        }

        getBook.setBookType(checkNull(getBook.getBookType(),bookModel.getBookType()));
        getBook.setBookTitle(checkNull(getBook.getBookTitle(),bookModel.getBookTitle()));
        getBook.setAuthor(checkNull(getBook.getAuthor(),bookModel.getAuthor()));
        getBook.setDescription(checkNull(getBook.getDescription(),bookModel.getDescription()));

        bookRepository.save(getBook);
        return "Update Complete";
    }

    public String deleteBook(int bookId)
    {
        String msg = null;
        Book book = bookRepository.findById(bookId).get();

        if(book==null)
        {
            return "Book not exists, Use Add Book function to added in store";
        }
        try {
            bookRepository.deleteById(bookId);
            msg = "Book Deleted";
        }catch(Exception ex)
        {
            return ex.getMessage();
        }

        return msg;
    }


    /**
     * use for check the book model value if null, use back book entity value
     * @param orignalValue current book entity value
     * @param updateValue pass in value for book model
     * @return string value
     */
    private String checkNull(String orignalValue, String updateValue)
    {
       return StringUtils.hasText(updateValue) ? updateValue: orignalValue;
    }

    protected boolean checkBookExists(String bookName)
    {
        return bookRepository.findByBookTitle(bookName) != null;
    }

}
