package com.telran.bankapplication.service.impl;

import com.telran.bankapplication.dto.AccountDTO;
import com.telran.bankapplication.entity.Account;
import com.telran.bankapplication.mapper.AccountMapper;
import com.telran.bankapplication.repository.AccountRepository;
import com.telran.bankapplication.service.AccountService;
import com.telran.bankapplication.service.exception.AccountNotFoundException;
import com.telran.bankapplication.service.exception.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountMapper accountMapper;
    private final AccountRepository accountRepository;

    @Override
    public AccountDTO getAccountByName(String name) {
        return accountMapper.toDTO(accountRepository.findAccountByName(name)
                .orElseThrow(() -> new AccountNotFoundException(String.format(
                        ErrorMessage.ACCOUNT_NOT_FOUND_BY_NAME, "name", name))));
    }

    @Override
    public List<AccountDTO> getAllAccounts() {
        List<Account> accountList = accountRepository.findAllAccount();
        if (accountList == null) {
            throw new AccountNotFoundException(ErrorMessage.ACCOUNTS_NOT_FOUND);
        } else {
            return accountMapper.toDTOList(accountList);
        }
    }

    @Override
    public AccountDTO getAccountById(String id) {
        return accountMapper.toDTO(accountRepository.findAccountById(UUID.fromString(id))
                .orElseThrow(() -> new AccountNotFoundException(String.format(
                        ErrorMessage.ACCOUNT_NOT_FOUND_BY_ID, "id", id))));
        }
}
