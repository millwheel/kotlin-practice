package com.example.bank.entity;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class AccountTest {

    @DisplayName("계좌 이름 변경 테스트")
    @Test
    public void changeAccountName() throws InterruptedException {
        Account account = new Account(UUID.randomUUID(), "121-123-412", "행복 저축 계좌");
        OffsetDateTime firstTime = account.getUpdatedAt();
        Thread.sleep(1000);
        account.updateName("행복 저축 청년 계좌");

        assertThat(account.getName()).isEqualTo("행복 저축 청년 계좌");
        assertThat(account.getUpdatedAt()).isAfter(firstTime);
    }

}