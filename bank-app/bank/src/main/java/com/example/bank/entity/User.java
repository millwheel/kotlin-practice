package com.example.bank.entity;

import com.example.bank.entity.base.BaseTimeEntity;
import lombok.Getter;

import java.util.UUID;

@Getter
public class User extends BaseTimeEntity {
    private final UUID id;
    private String name;
    private String phone;
    private String address;

    public User(String name, String phone, String address) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public void updateUserInformation(String name, String phone, String address){
        if (name != null) this.name = name;
        if (phone != null) this.phone = phone;
        if (address != null) this.address = address;
        updateDateTime();
    }
}
