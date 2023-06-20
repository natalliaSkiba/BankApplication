package com.telran.bankapplication.controller;

import com.telran.bankapplication.dto.ClientAfterCreateDto;
import com.telran.bankapplication.dto.ClientCreateDto;
import com.telran.bankapplication.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientAfterCreateDto createNewClient(@Valid @RequestBody ClientCreateDto clientCreateDto){
        return clientService.clientNewCreate(clientCreateDto);
    }
}
