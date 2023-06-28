package com.telran.bankapplication.controller;

import com.telran.bankapplication.dto.ManagerDTO;
import com.telran.bankapplication.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/managers")
@RequiredArgsConstructor
public class ManagerController {
    private final ManagerService managerService;

    @GetMapping(path = "/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ManagerDTO getManagerByName(@PathVariable("name") String name) {
        return managerService.getManagerByName(name);
    }

    @GetMapping(path = "/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ManagerDTO getManagerById(@PathVariable("id") String id) {
        return managerService.getManagerById(id);

    }
}
