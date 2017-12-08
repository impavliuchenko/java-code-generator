package com.codegen.controllers;

import com.codegen.entities.User;
import com.codegen.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("api/users")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }
}
