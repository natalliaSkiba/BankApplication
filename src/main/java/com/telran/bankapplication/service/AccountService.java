package com.telran.bankapplication.service;

import com.telran.bankapplication.dto.AccountDTO;

public interface AccountService {
    AccountDTO getAccountByName(String name);
}
