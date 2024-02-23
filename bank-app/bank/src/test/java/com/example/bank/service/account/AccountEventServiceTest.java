package com.example.bank.service.account;

import com.example.bank.entity.Account;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class AccountEventServiceTest {

    private final AccountEventService accountEventService;

    @Autowired
    AccountEventServiceTest(AccountEventService accountEventService) {
        this.accountEventService = accountEventService;
    }

    @Test
    public void createAndGetAccount(){
        String userId = UUID.randomUUID().toString();
        Account account1 = accountEventService.createAccount("133-1331-1223", userId);
        Account account2 = accountEventService.getAccount(account1.getId().toString());

        Assertions.assertThat(account1.getId()).isEqualTo(account2.getId());
    }
}