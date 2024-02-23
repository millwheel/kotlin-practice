package com.example.bank.service.user;

import com.example.bank.entity.User;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserService {

    public static final ConcurrentHashMap<UUID, User> userDB = new ConcurrentHashMap<>();

    public User createUser(String username, String password, String phone, String address){
        if(userDB.values().stream().anyMatch(user -> Objects.equals(user.getUsername(), username))){
            throw new RuntimeException("The user already has the account.");
        }
        User user = new User(username, phone, address, password);
        userDB.put(user.getId(), user);
        return user;
    }

    public User getUser(String userId){
        return userDB.get(UUID.fromString(userId));
    }

    public void deleteAll(){
        userDB.clear();
    }
}
