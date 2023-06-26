package com.telran.bankapplication.service;

import com.telran.bankapplication.dto.ManagerDTO;

public interface ManagerService {
    ManagerDTO getManagerByName(String name);

    ManagerDTO getManagerById(String id);
}
