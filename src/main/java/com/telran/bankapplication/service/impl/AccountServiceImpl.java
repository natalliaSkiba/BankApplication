package com.telran.bankapplication.service.impl;

import com.telran.bankapplication.dto.AccountDTO;
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
    private final String Account_NOT_FOUND = "Account : with %s %s doesn't exist in the database";

    @Override
    public AccountDTO getAccountByName(String name) {
        return accountMapper.toDTO(accountRepository.findAccountByName(name)
                .orElseThrow(() -> new AccountNotFoundException(String.format(ErrorMessage.ACCOUNT_NOT_FOUND_BY_NAME,"name",name))));
    }

    @Override
    public List<AccountDTO> getAllAccounts() {
        return accountMapper.toDTOList(accountRepository.findAllAccount());
    }

    @Override
    public AccountDTO getAccountById(String id)  {
        return accountMapper.toDTO(accountRepository.findAccountById(UUID.fromString(id))
                .orElseThrow(()-> new AccountNotFoundException(String.format(ErrorMessage.ACCOUNT_NOT_FOUND_BY_ID,"id",id))));
    }
}
