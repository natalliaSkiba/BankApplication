package com.telran.bankapplication.util;

import com.telran.bankapplication.entity.*;
import com.telran.bankapplication.entity.enums.AccountStatus;
import com.telran.bankapplication.entity.enums.AccountType;
import com.telran.bankapplication.entity.enums.ClientStatus;
import com.telran.bankapplication.entity.enums.CurrencyType;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.util.ArrayList;

@UtilityClass
public class EntityCreator {
    public static final String UUID_EXAMPLE = "50a9587b-95f5-495c-b74e-5771ee9df49d";
    public static final String NAME_ACCOUNT_OK = "GB29 NWBK 6016 1331 9268 20";
    public static final String NAME_MANAGER_OK = "Morosova";

    public static Account getAccountEntity() {
        Agreement agreement = getAgreementEntity();
        Client client = getClientEntity();
        return new Account(
                java.util.UUID.fromString(UUID_EXAMPLE),
                NAME_ACCOUNT_OK,
                AccountType.DEPOSIT,
                AccountStatus.ACTIVE,
                20000.0,
                CurrencyType.USD,
                LocalDateTime.of(2020, 1, 1, 0, 0, 0),
                LocalDateTime.of(2020, 1, 1, 0, 0, 0),
                client,
                null,
                null,
                agreement
        );
    }

    public static Agreement getAgreementEntity() {
        Agreement agreement = new Agreement();
        agreement.setId(1);
        agreement.setProduct(getProductEntity());
        agreement.setStatus(AccountStatus.ACTIVE);
        return agreement;
    }

    public static Client getClientEntity() {
        Manager manager = getManagerEntity();
        return new Client(
                java.util.UUID.fromString("13030d5e-72f5-4d8e-b82f-c88f879093ce"),
                ClientStatus.ACTIVE,
                "2206905511",
                "Alena",
                "Test",
                "ATest@gmail.com",
                "Minsk",
                "+375293456677",
                LocalDateTime.of(2020, 01, 01, 0, 0, 0),
                LocalDateTime.of(2020, 01, 01, 0, 0, 0),
                new ArrayList<>(),
                manager
        );
    }

    public static Product getProductEntity() {
        Product product = new Product();
        product.setId(1);
        return product;
    }

    public static Manager getManagerEntity() {
        Manager manager = new Manager();
        manager.setId(1L);
        manager.setFirstName("Oly");
        manager.setLastName("Morosova");
        return manager;
    }
}
