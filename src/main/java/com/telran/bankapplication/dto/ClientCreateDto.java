package com.telran.bankapplication.dto;

import lombok.Value;

@Value
public class ClientCreateDto {
    String taxCode;
    String firstName;
    String lastName;
    String email;
    String address;
    String phone;
    String managerLastName;
}
