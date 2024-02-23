package com.example.bank.service.ratelimit.token;

import com.example.bank.service.ratelimit.RateLimitService;

import java.util.concurrent.ConcurrentHashMap;

public class RateLimitServiceToken implements RateLimitService {
    private final ConcurrentHashMap<String, RequestTokenBucket> requestCounts = new ConcurrentHashMap<>();
    @Override
    public boolean isAllowed(String key) {
        return false;
    }
}
