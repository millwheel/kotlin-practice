package com.example.kotlinpractice.controller;

import com.example.kotlinpractice.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class HelloController {

    private final HelloService helloService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String hello(){
        helloService.logHello();
        return "hello";
    }
}
