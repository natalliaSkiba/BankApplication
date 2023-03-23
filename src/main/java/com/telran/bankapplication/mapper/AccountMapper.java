package com.telran.bankapplication.mapper;
import com.telran.bankapplication.dto.AccountDTO;
import com.telran.bankapplication.entity.Account;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface AccountMapper {
 AccountDTO toDTO(Account account);
}
