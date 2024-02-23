package com.example.bank.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @DisplayName("사용자 정보 변경 테스트")
    @Test
    public void changeUserName() throws InterruptedException {
        User user = new User("sion", "010-1234-5678", "경기도 수원시", "asdf");
        OffsetDateTime firstTime = user.getUpdatedAt();
        Thread.sleep(1000);
        user.updateUserInformation( "010-2345-2345", null);

        assertThat(user.getUpdatedAt()).isBefore(firstTime);
    }

}