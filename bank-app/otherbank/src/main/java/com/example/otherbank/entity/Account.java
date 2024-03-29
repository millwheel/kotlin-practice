package com.example.otherbank.entity;

import com.example.otherbank.entity.base.BaseTimeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Account extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID accountId;
    private String accountNumber;
    private String accountName;
    private String userId;

    public Account(String accountNumber, String accountName, String userId) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.userId = userId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getUserId() {
        return userId;
    }
}
