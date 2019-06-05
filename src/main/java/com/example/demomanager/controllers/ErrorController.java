package com.example.demomanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/oups")
public class ErrorController {

    @GetMapping
    public String error(){
        return "index";
    }
}
