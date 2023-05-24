package com.telran.bankapplication.mapper;

import com.telran.bankapplication.dto.AccountDTO;
import com.telran.bankapplication.entity.Account;
import com.telran.bankapplication.service.impl.AccountServiceImpl;
import com.telran.bankapplication.util.DtoCreator;
import com.telran.bankapplication.util.EntityCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;

import static org.junit.Assert.assertEquals;


@DisplayName("Account mapper test class")
class AccountMapperTest {
    @InjectMocks
    AccountMapper accountMapper = Mappers.getMapper(AccountMapper.class);
    //new AccountMapperImpl();

//    @DisplayName("Positive test. Account mapper to DTO test")
//    @Test
//    void testToDto() {
//        Account account = EntityCreator.getEntity();
//        AccountDTO expectedAccountDto = DtoCreator.getDto();
//        AccountDTO accountDTO = accountMapper.toDTO(account);
//        assertEquals(account.getName(), accountDTO.getName());
//        assertEquals(account.getType(), accountDTO.getType());
//        assertEquals(account.getStatus(), accountDTO.getStatus());
//        assertEquals(account.getBalance(), accountDTO.getBalance());
//        assertEquals(account.getCurrencyCode(), accountDTO.getCurrencyCode());
//        assertEquals(account.getClient().getId().toString(), accountDTO.getClient_id());
//        //assertEquals(account.getClient().getManager().getId().toString(), accountDTO.getManager_id());
//        assertEquals(account.getAgreement().getStatus(), accountDTO.getAgreement_status());
//        //Assertions.assertEquals(expectedAccountDto, accountMapper.toDTO(account));
//    }

    @Test
    void toDTOList() {
    }
}