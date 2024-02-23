package com.example.bank.service.account;

import com.example.bank.entity.Account;
import com.example.bank.entity.User;

import java.util.UUID;

public class AccountEventService {

    private static final String EVENT_ACCOUNT_NAME = "행복 저축 계좌";

    public void createAccount(){
        User user = new User("김민성", "010-7488-1000", "경기도");
        Account account = new Account(user.getId(), EVENT_ACCOUNT_NAME);
    }
}
