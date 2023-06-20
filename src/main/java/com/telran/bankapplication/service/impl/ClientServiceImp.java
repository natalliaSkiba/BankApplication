package com.telran.bankapplication.service.impl;

import com.telran.bankapplication.dto.ClientAfterCreateDto;
import com.telran.bankapplication.dto.ClientCreateDto;
import com.telran.bankapplication.entity.Client;
import com.telran.bankapplication.entity.Manager;
import com.telran.bankapplication.mapper.ClientMapper;
import com.telran.bankapplication.repository.ClientRepository;
import com.telran.bankapplication.repository.ManagerRepository;
import com.telran.bankapplication.service.ClientService;
import com.telran.bankapplication.service.exception.ClientAlreadyExistException;
import com.telran.bankapplication.service.exception.ErrorMessage;
import com.telran.bankapplication.service.exception.ManagerNotFuondException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ClientServiceImp implements ClientService {
    private final ClientMapper clientMapper;
    private final ClientRepository clientRepository;
    private final ManagerRepository managerRepository;

    @Override
    @Transactional
    public ClientAfterCreateDto clientNewCreate(ClientCreateDto clientCreateDto) {
        Client client = clientMapper.toCreateEntity(clientCreateDto);
        checkClientNotExist(client);
        client.setManager(findManager(clientCreateDto));
        return clientMapper.toAfterCreateDto(clientRepository.save(client));
    }

    private void checkClientNotExist(Client client) {
        clientRepository.findAll().forEach(e -> {
            if (e.equals(client)) {
                throw new ClientAlreadyExistException(ErrorMessage.CLIENT_ALREADY_EXIST);
            }
        });
    }

    private Manager findManager(ClientCreateDto clientCreateDto){
        var managerName = clientCreateDto.managerLastName();
        return managerRepository.findManagerByName(managerName)
                .orElseThrow(() -> new ManagerNotFuondException(ErrorMessage.MANAGER_NOT_FOUNDED));
    }
}
