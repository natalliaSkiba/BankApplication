package com.telran.bankapplication.service.impl;

import com.telran.bankapplication.dto.ClientAfterCreateDto;
import com.telran.bankapplication.dto.ClientCreateDto;
import com.telran.bankapplication.entity.Client;
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
        var managerName = clientCreateDto.getManagerLastName();
        var manager = managerRepository.findManagerByName(managerName)
                .orElseThrow(() -> new ManagerNotFuondException(ErrorMessage.MANAGER_NOT_FOUNDED));
        Client client = clientMapper.toCreateEntity(clientCreateDto);
        clientRepository.findAll().forEach(e -> {
            if (e.equals(client)) {
                throw new ClientAlreadyExistException(ErrorMessage.CLIENT_ALREADY_EXIST);
            }
        });
        client.setManager(manager);
        return clientMapper.toAfterCreateDto(clientRepository.save(client));
    }
}
