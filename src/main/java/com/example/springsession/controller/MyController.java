package com.example.springsession.controller;

import com.example.springsession.dto.ProductDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class MyController {

    @PostMapping(value = "/search")
    public String registerUser(@RequestBody ProductDTO request) {
        return request.toString();
    }
}