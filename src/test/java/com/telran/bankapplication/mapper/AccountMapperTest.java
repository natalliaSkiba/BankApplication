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

@DisplayName("Account mapper test class")
class AccountMapperTest {
    private final AccountMapper accountMapper = new AccountMapperImpl();
    private final Account account = EntityCreator.getAccountEntity();
    public List<Account> accountList;

    @DisplayName("Positive test. Account mapper to DTO test")
    @Test
    void testToDto() {
        AccountDTO expectedAccountDto = DtoCreator.getAccountDTO();
        AccountDTO actualAccountDto = accountMapper.toDTO(account);

        Assertions.assertEquals(expectedAccountDto.name(), actualAccountDto.name());
        Assertions.assertEquals(expectedAccountDto.type(), actualAccountDto.type());
        Assertions.assertEquals(expectedAccountDto.status(), actualAccountDto.status());
        Assertions.assertEquals(expectedAccountDto.balance(), actualAccountDto.balance());
        Assertions.assertEquals(expectedAccountDto.currencyCode(), actualAccountDto.currencyCode());
        Assertions.assertEquals(expectedAccountDto.client_id(), actualAccountDto.client_id());
        Assertions.assertEquals(expectedAccountDto.manager_id(), actualAccountDto.manager_id());
        Assertions.assertEquals(expectedAccountDto.agreement_status(), actualAccountDto.agreement_status());
        Assertions.assertEquals(expectedAccountDto.dataCreated(), actualAccountDto.dataCreated());
        Assertions.assertEquals(expectedAccountDto.dataUpdated(), actualAccountDto.dataUpdated());
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