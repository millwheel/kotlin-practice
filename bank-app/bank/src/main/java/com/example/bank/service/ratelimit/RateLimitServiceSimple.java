package com.example.bank.service.ratelimit;

import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class RateLimitServiceSimple implements RateLimitService {

    private ConcurrentHashMap<String, RequestCounter> requestCounter = new ConcurrentHashMap<>();

    public boolean isAllowed(String key){
        return true;
    }
}
