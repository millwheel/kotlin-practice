package com.example.bank.service.ratelimit;

import java.time.Duration;

public class RateLimitConstant {

    public static final int MAX_REQUESTS = 10;
    public static final Duration WINDOW_DURATION = Duration.ofSeconds(10);

}
