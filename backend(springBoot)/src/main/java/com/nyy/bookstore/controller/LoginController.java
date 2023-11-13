package com.nyy.bookstore.controller;

import com.nyy.bookstore.services.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="api/v1/login")
public class LoginController {

    @Autowired
    UserLoginService userLoginService;

    @CrossOrigin
    @PostMapping(path="/{username}&{password}")
    public boolean login(@RequestParam String username, @RequestParam String password)
    {
        return userLoginService.loginCheck(username,password);
    }

}
