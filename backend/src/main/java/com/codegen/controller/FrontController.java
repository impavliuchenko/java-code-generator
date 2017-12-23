package com.codegen.controller;

import com.codegen.util.security.TokenHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController("api/token")
public class FrontController {

    @Autowired
    private TokenHandler tokenHandler;

    @GetMapping
    public String getToken() {
        return tokenHandler.generateAccessToken(1L, LocalDateTime.now().plusDays(14));
    }
}
