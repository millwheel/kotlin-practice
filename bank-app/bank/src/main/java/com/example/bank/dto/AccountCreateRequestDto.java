package com.example.bank.dto;

import lombok.Data;

@Data
public class AccountCreateRequestDto {
    private String accountNumber;
    private String userId;
}
