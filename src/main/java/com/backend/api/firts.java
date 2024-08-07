package com.backend.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class firts {

    @GetMapping("/welcome")
    public String first_api() {
        return "Welcome to my first API project";
    }

}
