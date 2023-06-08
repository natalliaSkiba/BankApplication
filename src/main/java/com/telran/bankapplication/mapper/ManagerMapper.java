package com.telran.bankapplication.mapper;

import com.telran.bankapplication.dto.ManagerDTO;
import com.telran.bankapplication.entity.Manager;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ManagerMapper {

    ManagerDTO toDTO(Manager manager);


}
