package com.example.bank.service.ratelimit;

public interface RateLimitService {

    boolean isAllowed(String key);
}
