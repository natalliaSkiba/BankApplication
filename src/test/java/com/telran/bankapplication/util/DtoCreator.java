package com.telran.bankapplication.util;

import com.telran.bankapplication.dto.AccountDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DtoCreator {
    public static AccountDTO getDto() {
        String name = "GB29  NWBK 6016 1331 9268 20";
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
}
