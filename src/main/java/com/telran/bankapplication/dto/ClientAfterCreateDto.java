package com.telran.bankapplication.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class ClientAfterCreateDto {
    String id;
    String status;
    String taxCode;
    String firstName;
    String lastName;
    String email;
    String address;
    String phone;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    LocalDateTime dataClientCreated;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    LocalDateTime dataClientUpdated;
    String manager;
}
