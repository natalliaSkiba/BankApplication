package com.telran.bankapplication.controller;

import com.telran.bankapplication.dto.AccountDTO;
import com.telran.bankapplication.service.AccountService;
import com.telran.bankapplication.validation.annotation.Uuid;
import lombok.RequiredArgsConstructor;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Validated
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping(path = "/name/{name}")
    public AccountDTO getAccountByName(@PathVariable("name") String name) {
        return accountService.getAccountByName(name);
    }

    @GetMapping(path = "/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountDTO getAccountById(@Uuid
                                     @PathVariable("id") String id) {
        return accountService.getAccountById(id);
    }

    @GetMapping(path = "/all")
    public List<AccountDTO> getAllAccounts() {
        return accountService.getAllAccounts();
    }
}
