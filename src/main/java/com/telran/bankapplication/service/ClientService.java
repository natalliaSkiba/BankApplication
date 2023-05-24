package com.telran.bankapplication.service;

import com.telran.bankapplication.dto.ClientAfterCreateDto;
import com.telran.bankapplication.dto.ClientCreateDto;
import org.springframework.stereotype.Service;


public interface ClientService {
    ClientAfterCreateDto clientNewCreate(ClientCreateDto clientCreateDto);
}
