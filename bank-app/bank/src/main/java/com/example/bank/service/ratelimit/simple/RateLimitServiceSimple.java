package com.example.bank.service.ratelimit.simple;

import com.example.bank.service.ratelimit.RateLimitService;

import java.util.concurrent.ConcurrentHashMap;


public class RateLimitServiceSimple implements RateLimitService {

    private final ConcurrentHashMap<String, RequestSimpleCounter> requestCounts = new ConcurrentHashMap<>();

    public boolean isAllowed(String key){
        RequestSimpleCounter requestSimpleCounter = requestCounts.computeIfAbsent(key, k -> new RequestSimpleCounter());

        requestSimpleCounter.incrementRequestCount();
        if (requestSimpleCounter.isLimitExceeded()) {
                return false;
        }
        return true;
    }
}
