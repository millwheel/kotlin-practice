package com.example.bank.entity.base;

import lombok.Getter;

import java.time.OffsetDateTime;

@Getter
public abstract class BaseTimeEntity {
    private final OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public BaseTimeEntity() {
        createdAt = OffsetDateTime.now();
        updatedAt = OffsetDateTime.now();
    }

    public void updateDateTime(){
        updatedAt = OffsetDateTime.now();
    }

}
