package com.codegen.controller.api;

import com.codegen.model.User;
import com.codegen.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @GetMapping
    public List<User> getUsers(){
        return userServiceImpl.getAllUsers();
    }
}
