package com.telran.bankapplication.mapper;

import com.telran.bankapplication.dto.ClientAfterCreateDto;
import com.telran.bankapplication.dto.ClientCreateDto;
import com.telran.bankapplication.entity.Client;
import com.telran.bankapplication.entity.enums.ClientStatus;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring", imports = {LocalDateTime.class, ClientStatus.class})
public interface ClientMapper {
    @Mapping(target = "dataClientCreated", expression = "java(LocalDateTime.now())")
    @Mapping(target = "dataClientUpdated", expression = "java(LocalDateTime.now())")
    @Mapping(target = "status", expression = "java(ClientStatus.PENDING)")
    @Mapping(target = "manager", source = "client.manager.id")
    Client toCreateEntity(ClientCreateDto clientCreateDto);

    ClientAfterCreateDto toAfterCreateDto(Client client);

}
