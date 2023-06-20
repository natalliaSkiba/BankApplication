package com.telran.bankapplication.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record ClientAfterCreateDto(
        String id,
        String status,
        String taxCode,
        String firstName,
        String lastName,
        String email,
        String address,
        String phone,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        LocalDateTime dataClientCreated,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        LocalDateTime dataClientUpdated,
        String manager) {
}
