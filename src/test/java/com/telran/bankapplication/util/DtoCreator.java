package com.telran.bankapplication.util;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.telran.bankapplication.dto.AccountDTO;
import com.telran.bankapplication.dto.ClientAfterCreateDto;
import com.telran.bankapplication.dto.ClientCreateDto;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;

@UtilityClass
public class DtoCreator {
    public static AccountDTO getAccountDTO() {
        String name = "GB29 NWBK 6016 1331 9268 20";
        String type = "DEPOSIT";
        String status = "ACTIVE";
        String balance = "20000.0";
        String currencyCode = "USD";
        String client_id = "13030d5e-72f5-4d8e-b82f-c88f879093ce";
        String manager_id = "1";
        String agreement_status = "ACTIVE";
        String dataCreated = "2020-01-01T00:00:00";
        String dataUpdated = "2020-01-01T00:00:00";
        return new AccountDTO(name, type, status, balance, currencyCode, client_id, manager_id, agreement_status, dataCreated, dataUpdated);
    }

    public static ClientCreateDto getClientCreateDTO() {
        return new ClientCreateDto(
                "2206905511",
                "Alena",
                "Test",
                "ATesta@gmail.com",
                "Minsk",
                "+375293456677",
                "Morosova");
    }

    public static ClientAfterCreateDto getClientCreateAfterDTO() {
        return new ClientAfterCreateDto(
                "13030d5e-72f5-4d8e-b82f-c88f879093ce",
                "ACTIVE",
                "2206905511",
                "Alena",
                "Test",
                "ATest@gmail.com",
                "Minsk",
                "+375293456677",
                LocalDateTime.of(2020, 1, 1, 0, 0, 0),
                LocalDateTime.of(2020, 1, 1, 0, 0, 0),
                "Morosova");

    }
}