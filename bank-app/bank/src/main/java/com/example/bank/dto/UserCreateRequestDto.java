package com.example.bank.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserCreateRequestDto {

    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String phone;
    @NotNull
    private String address;

}
