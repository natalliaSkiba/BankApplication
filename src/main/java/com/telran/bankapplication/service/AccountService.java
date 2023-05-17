package com.telran.bankapplication.service;

import com.telran.bankapplication.dto.AccountDTO;

import java.util.List;

public interface AccountService {
    AccountDTO getAccountByName(String name);

    List<AccountDTO> getAllAccounts();

    AccountDTO getAccountById(String id) ;
}
