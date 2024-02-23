package com.example.bank.service.ratelimit.simple;

import com.example.bank.service.ratelimit.RateLimitConstant;

import java.time.Duration;
import java.time.LocalDateTime;

public class RequestSimpleCounter {
    private int requestCount;
    private LocalDateTime windowStart;
    private final Duration windowDuration;
    private final int maxRequests;

    public RequestSimpleCounter() {
        this.requestCount = 0;
        this.windowStart = LocalDateTime.now();
        this.windowDuration = RateLimitConstant.WINDOW_DURATION;
        this.maxRequests = RateLimitConstant.MAX_REQUESTS;
    }

    public synchronized void incrementRequestCount(){
        if (isWindowExpired()){
            resetWindow();
        }
        requestCount++;
    }

    public synchronized boolean isLimitExceeded() {
        if (isWindowExpired()) {
            resetWindow();
        }
        return requestCount > maxRequests;
    }

    private void resetWindow() {
        this.windowStart = LocalDateTime.now();
        this.requestCount = 0;
    }

    private boolean isWindowExpired() {
        return LocalDateTime.now().isAfter(windowStart.plus(windowDuration));
    }

}
