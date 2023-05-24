package com.telran.bankapplication.util;

import com.telran.bankapplication.entity.Account;
import com.telran.bankapplication.entity.Client;
import com.telran.bankapplication.entity.Manager;
import com.telran.bankapplication.entity.enums.AccountStatus;
import com.telran.bankapplication.entity.enums.AccountType;
import com.telran.bankapplication.entity.enums.CurrencyType;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@UtilityClass
public class EntityCreator {
    public static final String UUID_EXAMPLE = "50a9587b-95f5-495c-b74e-5771ee9df49d";
    public static final String NAME_OK = "GB29 NWBK 6016 1331 9268 20";
    public static Account getEntity(){
        // Создание объекта LocalDateTime из строки
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dataCreated = LocalDateTime.parse("2020-01-01 00:00:00", formatter);
        LocalDateTime dataUpdated = LocalDateTime.parse("2021-01-01 00:00:00", formatter);
       // Создаем объект клиента
        Client client = new Client();
        client.setId(UUID.fromString("f7160d0c-103f-4ace-a71c-e6a00d674063")); // задаем идентификатор клиента
        client.setFirstName("Oly");
        client.setLastName("Pavliva");
        // Создаем объект manager
        Manager manager = new Manager();
        manager.setId(1L);
        manager.setFirstName("Viktorya");
        manager.setLastName("Morosova");


        Account account = new Account();

        account.setId(UUID.fromString("50a9587b-95f5-495c-b74e-5771ee9df49d"));
        account.setName("GB29NWBK60161331443421");
        account.setType(AccountType.DEPOSIT);
        account.setStatus(AccountStatus.ACTIVE);
        account.setBalance(20000);
        account.setCurrencyCode(CurrencyType.USD);
        account.setClient(client);

        account.setDataCreated(dataCreated);
        account.setDataUpdated(dataUpdated);

        return new Account();
    }
}
