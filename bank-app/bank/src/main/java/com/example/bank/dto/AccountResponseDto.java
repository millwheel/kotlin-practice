package com.example.bank.dto;

import com.example.bank.entity.Account;
import lombok.Data;

@Data
public class AccountResponseDto {

    private String id;
    private String userid;
    private String name;

    public AccountResponseDto(Account account) {
        this.id = account.getId().toString();
        this.userid = account.getUserid().toString();
        this.name = account.getName();
    }
}
