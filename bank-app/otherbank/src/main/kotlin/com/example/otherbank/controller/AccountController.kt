package com.example.otherbank.controller

import com.example.otherbank.dto.AccountCreateRequestDto
import com.example.otherbank.service.AccountService
import lombok.extern.slf4j.Slf4j
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Slf4j
@RestController
@RequestMapping("/accounts")
class AccountController(val accountService: AccountService) {

    @PostMapping
    fun createAccount(@RequestBody createRequestDto: AccountCreateRequestDto){
        val createAccount = accountService.createAccount(
            createRequestDto.accountNumber,
            createRequestDto.accountName,
            createRequestDto.userName
        )
        println(createAccount.accountName);
        println(createAccount.accountNumber)
    }

}