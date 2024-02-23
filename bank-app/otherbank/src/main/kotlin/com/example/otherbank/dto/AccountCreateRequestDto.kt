package com.example.otherbank.dto



data class AccountCreateRequestDto (
    val accountNumber: String,
    val accountName: String,
    val userName: String,
)