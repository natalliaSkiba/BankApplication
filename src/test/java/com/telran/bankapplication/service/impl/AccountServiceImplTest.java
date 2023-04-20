package com.telran.bankapplication.service.impl;

import com.telran.bankapplication.dto.AccountDTO;
import com.telran.bankapplication.entity.Account;
import com.telran.bankapplication.mapper.AccountMapper;
import com.telran.bankapplication.repository.AccountRepository;
import com.telran.bankapplication.service.util.DtoCreator;
import com.telran.bankapplication.service.util.EntityCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

@DisplayName("Account service test class")
@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {
    @Mock
    AccountMapper accountMapper;
    @Mock
    AccountRepository accountRepository;

    @Test
    void getAccountByName() {
    }

    @Test
    void getAllAccounts() {
    }

    @Test
    @DisplayName("Positive test. Get account by id")
    void getAccountById() {
        Account account = EntityCreator.getEntity();
        AccountDTO accountDTO = DtoCreator.getDto();
        UUID uuid = UUID.fromString(EntityCreator.UUID_EXAMPLE);
        Mockito.when(accountRepository.findAccountById(uuid)).thenReturn(Optional.ofNullable(account));
        Mockito.when(accountMapper.toDTO(account)).thenReturn(accountDTO);
        Mockito.verify(accountRepository).findAccountById(uuid);
        Mockito.verify(accountMapper).toDTO(account);

    }
}