package com.telran.bankapplication.service.impl;

import com.telran.bankapplication.dto.AccountDTO;
import com.telran.bankapplication.entity.Account;
import com.telran.bankapplication.mapper.AccountMapper;
import com.telran.bankapplication.repository.AccountRepository;
import com.telran.bankapplication.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountMapper accountMapper;
    private final AccountRepository accountRepository;

    @Override
    public AccountDTO getAccountByName(String name) {
        return accountMapper.toDTO(accountRepository.findAccountByName(name).orElseThrow(()->new IllegalStateException("Account : " + name + " doesn't exist in the database")));

    }
}
