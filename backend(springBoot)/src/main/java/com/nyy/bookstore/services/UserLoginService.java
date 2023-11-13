package com.nyy.bookstore.services;

import com.nyy.bookstore.entity.BookstoreUser;
import com.nyy.bookstore.repository.BookstoreUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {

    @Autowired
    BookstoreUserRepository bookstoreUserRepository;

    public Boolean loginCheck(String username, String password)
    {

        BookstoreUser getUser = bookstoreUserRepository.findByUserName(username);

        if(getUser==null)
        {
            return false;
        }

        //enhance to hash function compare ltr
        if(!getUser.getPassword().equals(password))
        {
            return false;
        }

        return true;
    }

}
