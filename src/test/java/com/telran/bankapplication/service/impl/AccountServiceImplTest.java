package com.telran.bankapplication.service.impl;

import com.telran.bankapplication.dto.AccountDTO;
import com.telran.bankapplication.entity.Account;
import com.telran.bankapplication.mapper.AccountMapper;
import com.telran.bankapplication.repository.AccountRepository;
import com.telran.bankapplication.service.exception.AccountNotFoundException;
import com.telran.bankapplication.util.DtoCreator;
import com.telran.bankapplication.util.EntityCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Account service test class")
@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {
    @Mock
    AccountMapper accountMapper;
    @Mock
    AccountRepository accountRepository;
    @InjectMocks
    AccountServiceImpl accountService;

    @Test
    @DisplayName("Positive test . Get account by id")
    void testGetAccountByIdPositive() {
        Account account = EntityCreator.getAccountEntity();
        AccountDTO accountDTO = DtoCreator.getAccountDTO();
        UUID uuid = UUID.fromString(EntityCreator.UUID_EXAMPLE);

        Mockito.when(accountRepository.findAccountById(uuid)).thenReturn(Optional.ofNullable(account));
        Mockito.when(accountMapper.toDTO(account)).thenReturn(accountDTO);

        AccountDTO returnedAccountDTO = accountService.getAccountById(uuid.toString());

        Mockito.verify(accountRepository).findAccountById(uuid);
        Mockito.verify(accountMapper).toDTO(account);

        assertEquals(accountDTO.getName(), returnedAccountDTO.getName());
    }

    @Test
    @DisplayName("Negative test. Get account by Id.")
    void testGetAccountByIdNegative() {
        AccountNotFoundException exception = assertThrows(AccountNotFoundException.class, () -> {
            accountService.getAccountById(EntityCreator.UUID_EXAMPLE);
        });
        assertEquals("Account was not found by this Id", exception.getMessage());
    }

    @Test
    @DisplayName("Positive test . Get account by name")
    void testGetAccountByNamePositive() {
        Account account = EntityCreator.getAccountEntity();
        AccountDTO accountDTO = DtoCreator.getAccountDTO();

        Mockito.when(accountRepository.findAccountByName(EntityCreator.NAME_OK)).thenReturn(Optional.ofNullable(account));
        Mockito.when(accountMapper.toDTO(account)).thenReturn(accountDTO);

        AccountDTO returnedAccountDTO = accountService.getAccountByName(EntityCreator.NAME_OK);

        Mockito.verify(accountRepository).findAccountByName(EntityCreator.NAME_OK);
        Mockito.verify(accountMapper).toDTO(account);

        assertEquals(accountDTO.getName(), returnedAccountDTO.getName());
    }

    @Test
    @DisplayName("Negative test. Get account by Name.")
    void testGetAccountByNameNegative() {
        AccountNotFoundException exception = assertThrows(AccountNotFoundException.class, () -> {
            accountService.getAccountByName(EntityCreator.NAME_OK);
        });
        assertEquals("Account was not found by this name", exception.getMessage());
    }

    @Test
    @DisplayName("Positive test . Get all accounts")
    void testGetAllAccountPositive() {
        List<Account> accountList = new ArrayList<>();
        accountList.add(EntityCreator.getAccountEntity());
        List<AccountDTO> accountDTOList = new ArrayList<>();
        accountDTOList.add(DtoCreator.getAccountDTO());

        Mockito.when(accountRepository.findAllAccount()).thenReturn(accountList);
        Mockito.when(accountMapper.toDTOList(accountList)).thenReturn(accountDTOList);

        accountService.getAllAccounts();

        Mockito.verify(accountRepository).findAllAccount();
        Mockito.verify(accountMapper).toDTOList(accountList);
    }

    @Test
    @DisplayName("Negative test. There are no any accounts")
    void getNotExistAllAccountsByStatusTest() {
        Mockito.when(accountRepository.findAllAccount()).thenReturn(null);
        AccountNotFoundException exception = assertThrows(AccountNotFoundException.class, () -> {
            accountService.getAllAccounts();
        });
        assertEquals("Any accounts were not found", exception.getMessage());
    }
}