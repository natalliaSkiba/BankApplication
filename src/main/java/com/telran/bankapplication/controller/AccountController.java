package com.telran.bankapplication.controller;

import com.telran.bankapplication.dto.AccountDTO;
import com.telran.bankapplication.entity.Account;
import com.telran.bankapplication.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping(path = "/name/{name}")
    public AccountDTO getAccountByName(@PathVariable("name") String name) {
        return accountService.getAccountByName(name);
    }
    @GetMapping(path = "/id/{id}")
    public AccountDTO getAccountById(@PathVariable("id") String id) {
        return accountService.getAccountById(id);
    }

    @GetMapping
    public List<AccountDTO> getAllAccounts() {
        return accountService.getAllAccounts();
    }
}
