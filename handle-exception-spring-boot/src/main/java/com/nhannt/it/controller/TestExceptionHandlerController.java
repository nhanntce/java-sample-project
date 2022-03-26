package com.nhannt.it.controller;

import com.nhannt.it.exception.CustomException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestExceptionHandlerController {

    @GetMapping("/any-exception")
    public String anyException() throws Exception {
        throw new Exception("This is an any exception!!!");
    }

    @GetMapping("/specific-exception")
    public String specificException() throws Exception {
        throw new NullPointerException("This is an null pointer exception!!!");
    }

    @GetMapping("/custom-exception")
    public String customException() throws Exception {
        throw new CustomException();
    }
}
