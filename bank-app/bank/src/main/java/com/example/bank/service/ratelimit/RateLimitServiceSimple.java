package com.example.bank.service.ratelimit;

import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class RateLimitServiceSimple implements RateLimitService {

    private final ConcurrentHashMap<String, RequestCounter> requestCounts = new ConcurrentHashMap<>();

    public boolean isAllowed(String key){
        RequestCounter requestCounter = requestCounts.computeIfAbsent(key, k -> new RequestCounter(RateLimitConstant.WINDOW_DURATION));

        requestCounter.incrementRequestCount();
        int MAX_REQUESTS = RateLimitConstant.MAX_REQUESTS;
        if (requestCounter.isLimitExceeded(MAX_REQUESTS)) {
                return false;
        }
        return true;
    }
}
