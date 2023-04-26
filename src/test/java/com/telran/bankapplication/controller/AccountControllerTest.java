package com.telran.bankapplication.controller;

import com.telran.bankapplication.dto.AccountDTO;
import com.telran.bankapplication.repository.AccountRepository;
import com.telran.bankapplication.service.AccountService;
import com.telran.bankapplication.service.util.DtoCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import javax.security.auth.login.AccountNotFoundException;

import java.util.Optional;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AccountController.class)
@DisplayName("AccountController test class")
class AccountControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AccountService accountService;
    @InjectMocks
    private AccountController accountController;
    @Mock
    private AccountRepository accountRepository;


    //public static final String nameOk = "GB29 NWBK 6016 1331 9268 20";
    public static final String UUID_EXAMPLE = "50a9587b-95f5-495c-b74e-5771ee9df49d";


    @Test
    @DisplayName("Test positive scenario for getAccountById")
    void testPositiveGetAccountById() throws Exception {
        AccountDTO accountDTO = DtoCreator.getDto();
        when(accountService.getAccountById(UUID_EXAMPLE)).thenReturn(accountDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/accounts/id/50a9587b-95f5-495c-b74e-5771ee9df49d"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("GB29 NWBK 6016 1331 9268 20"))
                .andExpect(jsonPath("$.type").value("DEPOSIT"))
                .andExpect(jsonPath("$.status").value("ACTIVE"))
                .andExpect(jsonPath("$.balance").value("20000"))
                .andExpect(jsonPath("$.currencyCode").value("USD"))
                .andExpect(jsonPath("$.client_id").value("13030d5e-72f5-4d8e-b82f-c88f879093ce"))
                .andExpect(jsonPath("$.manager_id").value("1"))
                .andExpect(jsonPath("$.agreement_status").value("ACTIVE"))
                .andExpect(jsonPath("$.dataCreated").value("2022-01-01"))
                .andExpect(jsonPath("$.dataUpdated").value("2022-02-01"));

        Mockito.verify(accountService, Mockito.times(1)).getAccountById("50a9587b-95f5-495c-b74e-5771ee9df49d");
    }

    @Test
    void testNegativeGetAccountById() throws Exception {
        String nonExistentId = "non-existent-id";
        String message = "Account not found with id " + nonExistentId;

        Mockito.when(accountService.getAccountById(nonExistentId))
                .thenThrow(new AccountNotFoundException(message));
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            accountController.getAccountById(nonExistentId);
        });
        assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
        assertEquals(message, exception.getMessage());
        Mockito.verify(accountService, Mockito.times(0)).getAccountById(nonExistentId);
    }

    @Test
    void testNegativeGetAccountById1() throws Exception {
        String nonExistentId = "non-existent-id";
        String message = "Account not found with id " + nonExistentId;

        Mockito.when(accountService.getAccountById(nonExistentId))
                .thenThrow(new AccountNotFoundException(message));
        mockMvc.perform(MockMvcRequestBuilders.get("/accounts/id/" + nonExistentId))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message")
                        .value(message));

        Mockito.verify(accountService);
    }

    @Test
    void testNegativeGetAccountByI2() {
        String nonExistentId = "non-existent-id";
        Mockito.when(accountRepository.findAccountById(Mockito.any(UUID.class)))
                .thenReturn(Optional.empty());

        assertThrows(AccountNotFoundException.class, () -> {
            accountService.getAccountById(nonExistentId);
        });
    }

    @Test
    void getAccountByNamePositive() {

    }


    @Test
    void getAllAccounts() {
    }
}