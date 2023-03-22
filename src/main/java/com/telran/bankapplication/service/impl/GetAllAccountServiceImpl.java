package com.telran.bankapplication.service.impl;

import com.telran.bankapplication.mapper.GetAllAccountMapper;
import com.telran.bankapplication.service.GetAllAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetAllAccountServiceImpl implements GetAllAccountService {
 //   private final GetAllAccountRepository getAllAccountRepository;
    private final GetAllAccountMapper getAllAccountMapper;
}
