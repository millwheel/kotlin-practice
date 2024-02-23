package com.example.bank.service.account;

import com.example.bank.entity.Account;
import com.example.bank.entity.User;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class AccountEventService {


    private static final ConcurrentHashMap<UUID, Account> accountDB = new ConcurrentHashMap<>();
    private static final String EVENT_ACCOUNT_NAME = "행복 저축 계좌";

    public void createAccount(String userId){
        Account account = new Account(UUID.fromString(userId), EVENT_ACCOUNT_NAME);
        accountDB.put(account.getId(), account);
    }

    public Account getAccount(String accountId){
        return accountDB.get(UUID.fromString(accountId));
    }
}
