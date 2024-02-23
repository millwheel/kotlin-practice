package com.example.bank.service.ratelimit.token;

import com.example.bank.service.ratelimit.RateLimitService;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class RateLimitServiceToken implements RateLimitService {
    private final ConcurrentHashMap<String, RequestTokenBucket> requestTokenBuckets = new ConcurrentHashMap<>();
    @Override
    public boolean isAllowed(String ipAddress) {
        RequestTokenBucket requestTokenBucket = requestTokenBuckets.computeIfAbsent(ipAddress, k -> new RequestTokenBucket());
        return requestTokenBucket.tryConsume();
    }
}
