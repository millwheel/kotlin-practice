package com.example.bank.service.account;

import com.example.bank.entity.Account;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class AccountEventService {


    private static final ConcurrentHashMap<UUID, Account> accountDB = new ConcurrentHashMap<>();
    private static final String EVENT_ACCOUNT_NAME = "행복 저축 계좌";

    public Account createAccount(String userId){
        if(accountDB.values().stream().anyMatch(account -> Objects.equals(account.getUserid(), userId))){
            throw new RuntimeException("The user already has the account.");
        }
        Account account = new Account(UUID.fromString(userId), EVENT_ACCOUNT_NAME);
        accountDB.put(account.getId(), account);
        return account;
    }

    public Account getAccount(String accountId){
        return accountDB.get(UUID.fromString(accountId));
    }


    public void deleteAll(){
        accountDB.clear();
    }
}
