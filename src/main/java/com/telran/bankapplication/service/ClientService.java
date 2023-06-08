package com.telran.bankapplication.service;

import com.telran.bankapplication.dto.ClientAfterCreateDto;
import com.telran.bankapplication.dto.ClientCreateDto;

public interface ClientService {
    ClientAfterCreateDto clientNewCreate(ClientCreateDto clientCreateDto);

}
