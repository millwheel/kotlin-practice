package com.example.kotlinpractice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HelloService {

    public void logHello(){
        log.info("Hello success!");
    }
}
