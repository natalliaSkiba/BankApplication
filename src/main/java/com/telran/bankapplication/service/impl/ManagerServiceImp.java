package com.telran.bankapplication.service.impl;

import com.telran.bankapplication.dto.ManagerDTO;
import com.telran.bankapplication.mapper.ManagerMapper;
import com.telran.bankapplication.repository.ManagerRepository;
import com.telran.bankapplication.service.ManagerService;
import com.telran.bankapplication.service.exception.AccountNotFoundException;
import com.telran.bankapplication.service.exception.ErrorMessage;
import com.telran.bankapplication.service.exception.ManagerNotFuondException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManagerServiceImp implements ManagerService {
    private final ManagerRepository managerRepository;
    private final ManagerMapper managerMapper;

    @Override
    public ManagerDTO getManagerByName(String name) {
        return managerMapper.toDTO(managerRepository.findManagerByName(name)
                .orElseThrow(() -> new ManagerNotFuondException(String.format(ErrorMessage.MANAGER_NOT_FOUNDED, "name", name))));
    }

    @Override
    public ManagerDTO getManagerById(String id) {
        return managerMapper.toDTO(managerRepository.findManagerById(Long.parseLong(id))
                .orElseThrow(() -> new AccountNotFoundException(String.format(ErrorMessage.MANAGER_NOT_FOUNDED, "id", id))));

    }
}
