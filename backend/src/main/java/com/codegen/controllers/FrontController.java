package com.codegen.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontController {

    @RequestMapping("/login")
    public String index() {
        return "forward:/index.html";
    }
}
