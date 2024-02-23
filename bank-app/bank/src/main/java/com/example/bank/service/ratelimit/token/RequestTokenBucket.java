package com.example.bank.service.ratelimit.token;

import com.example.bank.service.ratelimit.RateLimitConstant;
import org.springframework.cglib.core.Local;

import java.time.Duration;
import java.time.LocalDateTime;

public class RequestTokenBucket {


    private LocalDateTime lastRefillTime;
    private LocalDateTime nextRefillTime;
    private final int maxRequestsPerWindow;
    private final Duration windowSize;
    private final int maxBucketSize;
    private int numberOfTokenAvailable;

    public RequestTokenBucket() {
        this.maxRequestsPerWindow = RateLimitConstant.MAX_REQUESTS;
        this.windowSize = RateLimitConstant.WINDOW_DURATION;
        this.maxBucketSize = RateLimitConstant.MAX_BUCKET_SIZE;
        this.lastRefillTime = LocalDateTime.now();
        this.nextRefillTime = this.lastRefillTime.plus(this.windowSize);
        this.numberOfTokenAvailable = this.maxBucketSize;
    }

    public boolean tryConsume(){
        if(LocalDateTime.now().isAfter(this.nextRefillTime)){
            refill();
        }
        if(this.numberOfTokenAvailable > 0){
            this.numberOfTokenAvailable--;
            return true;
        }
        return false;
    }

    private void refill(){
        this.lastRefillTime = LocalDateTime.now();
        this.nextRefillTime = this.lastRefillTime.plus(this.windowSize);
        this.numberOfTokenAvailable = Math.min(this.maxBucketSize, this.numberOfTokenAvailable + this.maxRequestsPerWindow);
    }
}
