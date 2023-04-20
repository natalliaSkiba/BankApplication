package com.telran.bankapplication.controller;

import com.telran.bankapplication.dto.AccountDTO;

import com.telran.bankapplication.service.AccountService;


import com.telran.bankapplication.service.util.DtoCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AccountController.class)
@DisplayName("AccountController test class")
@ExtendWith(MockitoExtension.class)
class AccountControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    AccountService accountService;

 public static final String nameOk = "GB29 NWBK 6016 1331 9268 20";


    @Test
    @DisplayName("Test positive scenario for getAccountById")
    void testPositiveGetAccountById() throws Exception {
        AccountDTO accountDTO = DtoCreator.getDto();
        Mockito.when(accountService.getAccountById("50a9587b-95f5-495c-b74e-5771ee9df49d")).thenReturn(accountDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/accounts/id/50a9587b-95f5-495c-b74e-5771ee9df49d)"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(nameOk))
                .andExpect(jsonPath("$.type").value("DEPOSIT"))
                .andExpect(jsonPath("$.status").value("ACTIVE"))
                .andExpect(jsonPath("$.balance").value("20000"))
                .andExpect(jsonPath("$.currencyCode").value("USD"))
                .andExpect(jsonPath("$.client_id").value("13030d5e-72f5-4d8e-b82f-c88f879093ce"))
                .andExpect(jsonPath("$.manager_id").value("1"))
                .andExpect(jsonPath("$.agreement_status").value("ACTIVE"))
                .andExpect(jsonPath("$.dataCreated").value("2022-01-01"))
                .andExpect(jsonPath("$.dataUpdated").value("2022-02-01"));

        Mockito.verify(accountService,Mockito.times(1)).getAccountById("50a9587b-95f5-495c-b74e-5771ee9df49d");
    }

    @Test
    void getAccountByNamePositive() {

    }

    @Test
    void getAccountById() {
    }

    @Test
    void getAllAccounts() {
    }
}