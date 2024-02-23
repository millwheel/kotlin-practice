package com.example.bank



data class AccountCreateRequestDto (
    val accountNumber: String,
    val accountName: String,
    val userName: String,
)