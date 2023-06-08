package com.telran.bankapplication.controller;

import com.telran.bankapplication.dto.ManagerDTO;
import com.telran.bankapplication.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/managers")
@RequiredArgsConstructor
public class ManagerController {
    private final ManagerService managerService;

    @GetMapping(path = "/name/{name}")
    public ManagerDTO getManagerByName(@PathVariable("name") String name) {
        return managerService.getManagerByName(name);
    }

    @GetMapping(path = "/id/{id}")
    public ManagerDTO getManagerById(@PathVariable("id") String id) {
        return managerService.getManagerById(id);

    }
}
