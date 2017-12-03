package com.codegen.controllers;

import com.codegen.entities.Car;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class HelloController {

    List <Car> list = new ArrayList<>(Arrays.asList(
            new Car(1, "Vanya"),
            new Car(2, "Alim")
    ));

    @RequestMapping("/api/hello")
    public List<Car> greet() {
        return list;
    }
}
