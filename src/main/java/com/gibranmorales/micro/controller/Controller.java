package com.gibranmorales.micro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


    @GetMapping("/Hola")
    public String Holamundo(){
        return "hola mundo";
    }
}
