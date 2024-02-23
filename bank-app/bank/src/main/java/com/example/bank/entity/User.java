package com.example.bank.entity;

import com.example.bank.entity.base.BaseTimeEntity;
import lombok.Getter;

import java.util.UUID;

@Getter
public class User extends BaseTimeEntity {
    private final UUID id;
    private String username;
    private String password;
    private String phone;
    private String address;

    public User(String username, String phone, String address, String password) {
        this.id = UUID.randomUUID();
        this.username = username;
        this.phone = phone;
        this.address = address;
        this.password = password;
    }

    public void updateUserInformation(String phone, String address){
        if (phone != null) this.phone = phone;
        if (address != null) this.address = address;
        updateDateTime();
    }
}
