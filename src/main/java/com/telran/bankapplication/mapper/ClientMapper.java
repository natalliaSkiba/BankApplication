package com.telran.bankapplication.mapper;

import com.telran.bankapplication.dto.ClientAfterCreateDto;
import com.telran.bankapplication.dto.ClientCreateDto;
import com.telran.bankapplication.entity.Client;
import com.telran.bankapplication.entity.Manager;
import com.telran.bankapplication.entity.enums.ClientStatus;
import com.telran.bankapplication.repository.ManagerRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring", imports = {LocalDateTime.class, ClientStatus.class, ManagerRepository.class})
public interface ClientMapper {

    @Mapping(target = "dataClientCreated", expression = "java(LocalDateTime.now())")
    @Mapping(target = "dataClientUpdated", expression = "java(LocalDateTime.now())")
    @Mapping(target = "status", expression = "java(ClientStatus.PENDING)")
      Client toCreateEntity(ClientCreateDto clientCreateDto);

    @Mapping(source = "manager", target = "manager", qualifiedByName = "managerLastName")
    ClientAfterCreateDto toAfterCreateDto(Client client);

    @Named("managerLastName")
    default String managerToString(Manager manager) {
        return manager.getLastName();
    }
}
