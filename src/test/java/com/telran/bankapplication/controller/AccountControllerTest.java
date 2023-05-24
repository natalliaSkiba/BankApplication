package com.telran.bankapplication.controller;

import com.telran.bankapplication.dto.AccountDTO;
import com.telran.bankapplication.service.AccountService;
import com.telran.bankapplication.util.DtoCreator;
import com.telran.bankapplication.util.EntityCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

    @Test
    @DisplayName("Test positive scenario for getAccountById, Status 200(OK), JSON response")
    void testPositiveGetAccountById() throws Exception {
        AccountDTO accountDTO = DtoCreator.getDto();
        when(accountService.getAccountById(EntityCreator.UUID_EXAMPLE)).thenReturn(accountDTO);
        mockMvc.perform(get("/accounts/id/" + EntityCreator.UUID_EXAMPLE))
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
        Mockito.verify(accountService, Mockito.times(1)).getAccountById(EntityCreator.UUID_EXAMPLE);
    }

    @Test
    @DisplayName("Test negative scenario for getAccountById, invalid ID")
    void testNegativeGetAccountById() throws Exception {
        String invalidId = "1";
        mockMvc.perform(get("/id/" + invalidId))
                .andExpect(status().is4xxClientError());
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            accountController.getAccountById(invalidId);
        });
        String expectedErrorMessage = "Invalid UUID";
        String actualErrorMessage = exception.getMessage();
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Test
    @DisplayName("Test positive scenario for getAccountByName, Status 200(OK), JSON response")
    void getAccountByNamePositive() throws Exception{
        AccountDTO accountDTO = DtoCreator.getDto();
        when(accountService.getAccountByName(EntityCreator.NAME_OK)).thenReturn(accountDTO);
        mockMvc.perform(get("/accounts/name/" + EntityCreator.NAME_OK))
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
        Mockito.verify(accountService, Mockito.times(1)).getAccountByName(EntityCreator.NAME_OK);
    }

    @Test
    @DisplayName("Test negative scenario for getAccountByName")
    void testNegativeGetAccountByName() throws Exception {
        String invalidName = "Joy";
        mockMvc.perform(get("/name/" + invalidName))
                .andExpect(status().is4xxClientError());
    }

    @Test
    @DisplayName("Test positive scenario for getAllAccounts, Status 200(OK), JSON response")
    void testGetAllAccountsPositive()throws Exception {
        List<AccountDTO> listAccountDTO = new ArrayList<>();
        listAccountDTO.add(DtoCreator.getDto());
        when(accountService.getAllAccounts()).thenReturn(listAccountDTO);
        mockMvc.perform(get("/accounts/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].name").value("GB29 NWBK 6016 1331 9268 20"))
                .andExpect(jsonPath("$[0].type").value("DEPOSIT"))
                .andExpect(jsonPath("$[0].status").value("ACTIVE"))
                .andExpect(jsonPath("$[0].balance").value("20000"))
                .andExpect(jsonPath("$[0].currencyCode").value("USD"))
                .andExpect(jsonPath("$[0].client_id").value("13030d5e-72f5-4d8e-b82f-c88f879093ce"))
                .andExpect(jsonPath("$[0].manager_id").value("1"))
                .andExpect(jsonPath("$[0].agreement_status").value("ACTIVE"))
                .andExpect(jsonPath("$[0].dataCreated").value("2022-01-01"))
                .andExpect(jsonPath("$[0].dataUpdated").value("2022-02-01"));
        Mockito.verify(accountService, Mockito.times(1)).getAllAccounts();
    }
}