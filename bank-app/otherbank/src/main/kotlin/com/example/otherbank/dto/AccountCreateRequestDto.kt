package com.example.otherbank.dto

import java.time.OffsetDateTime


data class AccountCreateRequestDto (
    val accountNumber: String,
    val accountName: String,
    val userName: String,
    val createAt: OffsetDateTime
)