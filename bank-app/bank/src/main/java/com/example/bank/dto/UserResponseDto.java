package com.example.bank.dto;

import com.example.bank.entity.User;
import lombok.Data;

@Data
public class UserResponseDto {

    private String username;
    private String phone;
    private String address;

    public UserResponseDto(User user) {
        this.username = user.getUsername();
        this.phone = user.getPhone();
        this.address = user.getAddress();
    }
}
