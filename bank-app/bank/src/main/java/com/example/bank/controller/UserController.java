package com.example.bank.controller;

import com.example.bank.dto.AccountCreateRequestDto;
import com.example.bank.dto.AccountResponseDto;
import com.example.bank.dto.UserCreateRequestDto;
import com.example.bank.dto.UserResponseDto;
import com.example.bank.entity.Account;
import com.example.bank.entity.User;
import com.example.bank.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createAccount(@RequestBody UserCreateRequestDto userCreateRequestDto){
        User user = userService.createUser(userCreateRequestDto.getUsername(),
                userCreateRequestDto.getPassword(),
                userCreateRequestDto.getPhone(),
                userCreateRequestDto.getAddress());
        return user.getId().toString();
    }


    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponseDto getAccount(@PathVariable String userId){
        User user = userService.getUser(userId);
        return new UserResponseDto(user);
    }
}
