package com.telran.bankapplication.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Value;

@Value
public class AccountDTO {
    String name;
    String type;
    String status;
    String balance;
    String currencyCode;
    String client_id;
    String manager_id;
    String agreement_status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    String dataCreated;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    String dataUpdated;
}
