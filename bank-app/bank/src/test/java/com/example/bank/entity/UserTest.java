package com.example.bank.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @DisplayName("사용자 정보 변경 테스트")
    @Test
    public void changeUserName() throws InterruptedException {
        User user = new User("김민성", "010-1234-5678", "경기도 수원시");
        OffsetDateTime firstUpdateTime = user.getUpdatedAt();
        Thread.sleep(1000);
        user.updateUserInformation("김민국", null, null);
        OffsetDateTime secondUpdateTime = user.getUpdatedAt();

        assertThat(user.getName()).isEqualTo("김민국");
        assertThat(firstUpdateTime).isBefore(secondUpdateTime);
    }

}