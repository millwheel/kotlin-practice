package com.example.otherbank.repository;

import com.example.otherbank.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<UUID, Account> {
}
