package com.example.bank.service.ratelimit;

import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class RateLimitServiceSimple implements RateLimitService {

    private final ConcurrentHashMap<String, RequestCounter> requestCounts = new ConcurrentHashMap<>();
    private final int MAX_REQUESTS = 100;
    private final Duration WINDOW_DURATION = Duration.ofMinutes(1);

    public boolean isAllowed(String key){
        RequestCounter requestCounter = requestCounts.computeIfAbsent(key, k -> new RequestCounter(WINDOW_DURATION));

        requestCounter.incrementRequestCount();
        if (requestCounter.isLimitExceeded(MAX_REQUESTS)) {
                return false;
        }

        return true;
    }
}
