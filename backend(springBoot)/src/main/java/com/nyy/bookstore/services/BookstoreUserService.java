package com.nyy.bookstore.services;

import com.nyy.bookstore.entity.Book;
import com.nyy.bookstore.entity.BookstoreUser;
import com.nyy.bookstore.repository.BookstoreUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookstoreUserService {
    @Autowired
    BookstoreUserRepository bookstoreUserRepository;

    public String addUser(BookstoreUser userModel)
    {
        String userName = userModel.getUserName();


        if(checkUserExists(userName))
        {
            return "Username has been taken";
        }
        BookstoreUser user =  bookstoreUserRepository.save(userModel);

        if(user!=null)
        {
            return "Registration Done";
        }

        return "Error on Registration";
    }


    public List<BookstoreUser> getUserList()
    {
        return bookstoreUserRepository.findAll();
    }

    public BookstoreUser getUserById(int userId)
    {
        return bookstoreUserRepository.findById(userId).get();
    }

    public String deleteUserById(int userId)
    {
        String msg = "User deleted";
        try {
            bookstoreUserRepository.deleteById(userId);
        }catch(Exception ex){
            return ex.getMessage();
    }
        return msg;
    }


    protected boolean checkUserExists(String username)
    {
        return bookstoreUserRepository.findByUserName(username) != null;
    }

}
