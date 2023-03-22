package com.telran.bankapplication.repository;

import com.telran.bankapplication.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface GetAllAccountRepository extends JpaRepository<Account, UUID> {
    List<Account> findAllById(Account account, UUID uuid);
}
