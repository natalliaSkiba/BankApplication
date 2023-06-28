package com.telran.bankapplication.service.impl;

import com.telran.bankapplication.dto.ClientAfterCreateDto;
import com.telran.bankapplication.dto.ClientCreateDto;
import com.telran.bankapplication.entity.Client;
import com.telran.bankapplication.entity.Manager;
import com.telran.bankapplication.mapper.ClientMapper;
import com.telran.bankapplication.repository.ClientRepository;
import com.telran.bankapplication.repository.ManagerRepository;
import com.telran.bankapplication.service.exception.ClientAlreadyExistException;
import com.telran.bankapplication.service.exception.ManagerNotFuondException;
import com.telran.bankapplication.util.DtoCreator;
import com.telran.bankapplication.util.EntityCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Client service test class")
@ExtendWith(MockitoExtension.class)
class ClientServiceImpTest {
    @Mock
    ClientRepository clientRepository;
    @Mock
    ClientMapper clientMapper;
    @Mock
    ManagerRepository managerRepository;
    @InjectMocks
    ClientServiceImp clientServiceImp;
    private final Client client = EntityCreator.getClientEntity();
    private final Manager manager = EntityCreator.getManagerEntity();

    @Test
    @DisplayName("Positive test. Create new client")
    void testClientNewCreate() {
        ClientCreateDto clientCreateDto = DtoCreator.getClientCreateDTO();
        ClientAfterCreateDto clientAfterCreateDto = DtoCreator.getClientCreateAfterDTO();
        List<Client> clientList = new ArrayList<>();

        Mockito.when(clientRepository.findAll()).thenReturn(clientList);
        Mockito.when(clientMapper.toCreateEntity(clientCreateDto)).thenReturn(client);
        Mockito.when(clientMapper.toAfterCreateDto(client)).thenReturn(clientAfterCreateDto);
        Mockito.when(clientRepository.save(client)).thenReturn(client);
        Mockito.when(managerRepository.findManagerByName(EntityCreator.NAME_MANAGER_OK))
                .thenReturn(Optional.ofNullable(manager));

        clientServiceImp.clientNewCreate(clientCreateDto);

        Mockito.verify(clientRepository).findAll();
        Mockito.verify(clientMapper).toCreateEntity(clientCreateDto);
        Mockito.verify(clientMapper).toAfterCreateDto(client);
        Mockito.verify(clientRepository).save(client);
        Mockito.verify(managerRepository).findManagerByName(EntityCreator.NAME_MANAGER_OK);
    }

    @DisplayName("Negative test. Create new client. Client already exist")
    @Test
    void testNegativeNewClientAlreadyExist() {
        ClientCreateDto clientCreateDto = DtoCreator.getClientCreateDTO();
        List<Client> clientList = new ArrayList<>();
        clientList.add(client);

        Mockito.when(clientMapper.toCreateEntity(clientCreateDto)).thenReturn(client);
        Mockito.when(clientRepository.findAll()).thenReturn(clientList);
        assertThrows(ClientAlreadyExistException.class, () -> clientServiceImp.clientNewCreate(clientCreateDto));
    }

    @DisplayName("Negative test. Create new client. Manager don't  exist")
    @Test
    void testNegativeNewClientNoManager() {
        ClientCreateDto clientCreateDto = DtoCreator.getClientCreateDTO();
        List<Client> clientList = new ArrayList<>();

        Mockito.when(clientRepository.findAll()).thenReturn(clientList);
        Mockito.when(clientMapper.toCreateEntity(clientCreateDto)).thenReturn(client);
        Mockito.when(managerRepository.findManagerByName(Mockito.anyString())).thenReturn(Optional.empty());

        assertThrows(ManagerNotFuondException.class, () -> clientServiceImp.clientNewCreate(clientCreateDto));
    }
}