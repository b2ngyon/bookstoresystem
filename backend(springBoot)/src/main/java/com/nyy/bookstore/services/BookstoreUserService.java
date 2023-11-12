package com.nyy.bookstore.services;

import com.nyy.bookstore.entity.Book;
import com.nyy.bookstore.entity.BookstoreUser;
import com.nyy.bookstore.repository.BookstoreUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

    public String updateUser(BookstoreUser userModel)
    {
        BookstoreUser getUser = bookstoreUserRepository.findById(userModel.getUserId()).get();

        if(getUser==null)
        {
            return "User not exists";
        }

        getUser.setUserName(checkNull(getUser.getUserName(),userModel.getUserName()));
        getUser.setFirstName(checkNull(getUser.getFirstName(),userModel.getFirstName()));
        getUser.setLastName(checkNull(getUser.getLastName(),userModel.getLastName()));
        getUser.setAddress(checkNull(getUser.getAddress(),userModel.getAddress()));

        bookstoreUserRepository.save(getUser);
        return "Update Complete";
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

    protected boolean checkUserExists(String username)
    {
        return bookstoreUserRepository.findByUserName(username) != null;
    }

}
