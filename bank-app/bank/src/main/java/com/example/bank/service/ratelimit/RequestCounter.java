package com.example.bank.service.ratelimit;

import java.time.Duration;
import java.time.LocalDateTime;

public class RequestCounter {
    private int requestCount;
    private LocalDateTime windowStart;
    private final Duration windowDuration;

    public RequestCounter(Duration duration) {
        this.requestCount = 0;
        this.windowStart = LocalDateTime.now();
        this.windowDuration = duration;
    }

    public synchronized void incrementRequestCount(){
        if (isWindowExpired()){
            resetWindow();
        }
        requestCount++;
    }

    public synchronized boolean isLimitExceeded(int maxRequests) {
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
