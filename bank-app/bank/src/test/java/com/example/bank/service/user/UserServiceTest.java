package com.example.bank.service.user;

import com.example.bank.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {

    private final UserService userService;

    @Autowired
    UserServiceTest(UserService userService) {
        this.userService = userService;
    }

    @Test
    public void createAndGetUser(){
        User user1 = userService.createUser("senor", "wjfmw123", "010-1843-8727", "경기도");
        User user2 = userService.getUser(user1.getId().toString());
        Assertions.assertThat(user2.getId()).isEqualTo(user1.getId());
    }
}