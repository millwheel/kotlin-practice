package com.example.otherbank.controller

import com.example.otherbank.dto.AccountCreateRequestDto
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/accounts")
class AccountController(
) {

    @PostMapping
    fun createAccount(@RequestBody createRequestDto: AccountCreateRequestDto){

    }

}