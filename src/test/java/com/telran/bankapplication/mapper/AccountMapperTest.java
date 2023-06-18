package com.telran.bankapplication.mapper;

import com.telran.bankapplication.dto.AccountDTO;
import com.telran.bankapplication.entity.Account;
import com.telran.bankapplication.util.DtoCreator;
import com.telran.bankapplication.util.EntityCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


@DisplayName("Account mapper test class")
class AccountMapperTest {
    private final AccountMapper accountMapper = new AccountMapperImpl();
    private final Account account = EntityCreator.getAccountEntity();
    private List<Account> accountList;


    @DisplayName("Positive test. Account mapper to DTO test")
    @Test
    void testToDto() {
        AccountDTO expectedAccountDto = DtoCreator.getAccountDTO();
        AccountDTO actualAccountDto = accountMapper.toDTO(account);

        Assertions.assertEquals(expectedAccountDto.getName(), actualAccountDto.getName());
        Assertions.assertEquals(expectedAccountDto.getType(), actualAccountDto.getType());
        Assertions.assertEquals(expectedAccountDto.getStatus(), actualAccountDto.getStatus());
        Assertions.assertEquals(expectedAccountDto.getBalance(), actualAccountDto.getBalance());
        Assertions.assertEquals(expectedAccountDto.getCurrencyCode(), actualAccountDto.getCurrencyCode());
        Assertions.assertEquals(expectedAccountDto.getClient_id(), actualAccountDto.getClient_id());
        Assertions.assertEquals(expectedAccountDto.getManager_id(), actualAccountDto.getManager_id());
        Assertions.assertEquals(expectedAccountDto.getAgreement_status(), actualAccountDto.getAgreement_status());
        Assertions.assertEquals(expectedAccountDto.getDataCreated(), actualAccountDto.getDataCreated());
        Assertions.assertEquals(expectedAccountDto.getDataUpdated(), actualAccountDto.getDataUpdated());
    }
    @DisplayName("Negative test. Null mapper to DTO test")
    @Test
    void TestToDtoNull() {
        Assertions.assertNull(accountMapper.toDTO(null));
    }

    @DisplayName("Positive test. Accounts list mapper to list DTO")
    @Test
    void testToListDto() {
        accountList = new ArrayList<>();
        accountList.add(account);
        AccountDTO expectedAccountDto = DtoCreator.getAccountDTO();
        List<AccountDTO> expectedAccountDtoList = new ArrayList<>();
        expectedAccountDtoList.add(expectedAccountDto);
        Assertions.assertEquals(expectedAccountDtoList, accountMapper.toDTOList(accountList));
    }
    @DisplayName("Negative test. Accounts list null mapper to list DTO")
    @Test
    void toListDtoNullTest() {
        Assertions.assertNull(accountMapper.toDTOList(null));
    }
}