package com.nyy.bookstore.controller;

import com.nyy.bookstore.entity.BookstoreUser;
import com.nyy.bookstore.services.BookstoreUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/user")
public class BookstoreUserController {
    @Autowired
    BookstoreUserService bookstoreUserService;

    @CrossOrigin
    @GetMapping(path="/getUserList")
    public List<BookstoreUser> getUserList()
    {
        return bookstoreUserService.getUserList();
    }

    @CrossOrigin
    @PostMapping(path="/addUser")
    public String addUser(@RequestBody BookstoreUser userModel)
    {
        return bookstoreUserService.addUser(userModel);
    }

    @CrossOrigin
    @PostMapping(path="/updateUser")
    public String updateUserDetail(@RequestBody BookstoreUser userModel)
    {
        return bookstoreUserService.updateUser(userModel);
    }

    @CrossOrigin
    @PostMapping(path="/deleteUser/{userId}")
    public String deleteUser(@RequestParam(name="userId") int userId)
    {
        return bookstoreUserService.deleteUserById(userId);
    }





}
