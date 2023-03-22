package com.telran.bankapplication.controller;

import com.telran.bankapplication.service.GetAllAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/all-controller")
@RequiredArgsConstructor
public class GetAllAccountController {
   private final GetAllAccountService getAllAccountService;
}
