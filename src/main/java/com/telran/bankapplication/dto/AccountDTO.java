package com.telran.bankapplication.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AccountDTO {
    String name;
    String type;
    String status;
    String balance;
    String currencyCode;
    @JsonFormat
    String dataCreated;
    String dataUpdated;

}
