package com.example.bank.service.ratelimit.simple;

import com.example.bank.service.ratelimit.RateLimitConstant;
import com.example.bank.service.ratelimit.RateLimitService;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class RateLimitServiceSimple implements RateLimitService {

    private final ConcurrentHashMap<String, RequestSimpleCounter> requestCounts = new ConcurrentHashMap<>();

    public boolean isAllowed(String key){
        RequestSimpleCounter requestSimpleCounter = requestCounts.computeIfAbsent(key, k -> new RequestSimpleCounter(RateLimitConstant.WINDOW_DURATION));

        requestSimpleCounter.incrementRequestCount();
        int MAX_REQUESTS = RateLimitConstant.MAX_REQUESTS;
        if (requestSimpleCounter.isLimitExceeded(MAX_REQUESTS)) {
                return false;
        }
        return true;
    }
}
