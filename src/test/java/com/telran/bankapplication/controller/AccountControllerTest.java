package com.telran.bankapplication.controller;

import com.telran.bankapplication.dto.AccountDTO;

import com.telran.bankapplication.service.AccountService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.jupiter.api.io.CleanupMode;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.mockito.BDDMockito.given;
import static org.slf4j.MDC.get;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AccountController.class)
@DisplayName("AccountController test class")
@RunWith(SpringRunner.class)
class AccountControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    AccountService accountService;
    private AccountDTO testAccount;
    private String nameOk = "GB29 NWBK 6016 1331 9268 20";

    @BeforeEach
    void setUp() {
        testAccount = createTestAccountDTO();
    }

    private AccountDTO createTestAccountDTO() {
        String name = "GB29 NWBK 6016 1331 9268 20";
        String type = "DEPOSIT";
        String status = "ACTIVE";
        String balance = "20000";
        String currencyCode = "USD";
        String client_id = "13030d5e-72f5-4d8e-b82f-c88f879093ce";
        String manager_id = "1";
        String agreement_status = "ACTIVE";
        String dataCreated = "2022-01-01";
        String dataUpdated = "2022-02-01";

        return new AccountDTO(name, type, status, balance, currencyCode, client_id, manager_id, agreement_status, dataCreated, dataUpdated);
    }

    //    private Account createTestAccount(){
//        Account account = new Account();
//        account.setId(UUID.fromString("UUID_TO_BIN('50a9587b-95f5-495c-b74e-5771ee9df49d')"));
//        account.setName("GB29NWBK60161331443421");
//        account.setType();
//        account.setStatus();
//        account.setBalance();
//        account.setCurrencyCode();
//        account.setDataCreated();
//        account.setDataUpdated();
//        account.setClient(UUID.fromString("UUID_TO_BIN('f7160d0c-103f-4ace-a71c-e6a00d674063')"));
//    }
    @Test
    @DisplayName("Test positive scenario for getAccountById")
    void testPositiveGetAccountById() throws Exception {
        AccountDTO accountDTO = createTestAccountDTO();
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