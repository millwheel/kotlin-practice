package com.example.bank.controller;

import com.example.bank.dto.AccountCreateRequestDto;
import com.example.bank.dto.AccountResponseDto;
import com.example.bank.entity.Account;
import com.example.bank.service.account.AccountEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountEventService accountEventService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createAccount(@RequestBody AccountCreateRequestDto accountCreateRequestDto){
        Account account = accountEventService.createAccount(accountCreateRequestDto.getUserId());
        return account.getId().toString();
    }


    @GetMapping("/{accountId}")
    @ResponseStatus(HttpStatus.OK)
    public AccountResponseDto getAccount(@PathVariable String accountId){
        Account account = accountEventService.getAccount(accountId);
        return new AccountResponseDto(account);
    }
}
