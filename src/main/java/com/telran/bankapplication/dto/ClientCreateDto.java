package com.telran.bankapplication.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.NonNull;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class ClientCreateDto {
    @NonNull
    String taxCode;
    @NonNull
    String firstName;
    @NonNull
    String lastName;
    @NonNull
    String email;
    @NonNull
    String address;
    @NonNull
    String phone;
    @NonNull
    String managerLastName;
}
