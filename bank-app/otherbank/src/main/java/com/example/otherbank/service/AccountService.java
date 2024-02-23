package com.example.otherbank.service;

import com.example.otherbank.entity.Account;
import com.example.otherbank.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public Account createAccount(String accountNumber, String accountName, String userId){
        Account account = new Account(accountNumber, accountName, userId);
        accountRepository.save(account);
        return account;
    }
}
