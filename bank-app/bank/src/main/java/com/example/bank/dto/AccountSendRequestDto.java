package com.example.bank.dto;

import lombok.Data;

@Data
public class AccountSendRequestDto {
    private String accountNumber;
    private String accountName;
    private String userName;

    public AccountSendRequestDto(String accountNumber, String accountName, String userName) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.userName = userName;
    }
}
