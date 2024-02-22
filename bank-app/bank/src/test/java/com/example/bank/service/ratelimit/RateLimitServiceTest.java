package com.example.bank.service.ratelimit;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RateLimitServiceTest {

    private final RateLimitService rateLimitService;

    @Autowired
    RateLimitServiceTest(RateLimitService rateLimitService) {
        this.rateLimitService = rateLimitService;
    }

    @DisplayName("10회 미만 요청")
    @Test
    void under10request() {
        String ipAddress = "101.103.98.125";
        boolean[] result = new boolean[10];
        for(int i = 0; i < 10; i++){
            result[i] = rateLimitService.isAllowed(ipAddress);
        }
        Assertions.assertThat(result).containsOnly(true);
    }

}