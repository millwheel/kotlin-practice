package com.example.bank.entity;

import com.example.bank.entity.base.BaseTimeEntity;
import lombok.Getter;

import java.util.UUID;


@Getter
public class Account extends BaseTimeEntity {

    private final UUID id;
    private final UUID userid;
    private String name;

    public Account(UUID userid, String name) {
        this.id = UUID.randomUUID();
        this.userid = userid;
        this.name = name;
    }

    public void updateName(String name) {
        this.name = name;
        updateDateTime();
    }

}
