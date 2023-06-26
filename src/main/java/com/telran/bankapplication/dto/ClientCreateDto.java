package com.telran.bankapplication.dto;


import jakarta.validation.constraints.NotNull;

public record ClientCreateDto(
        @NotNull
        String taxCode,
        String firstName,
        String lastName,
        String email,
        String address,
        String phone,
        String managerLastName) {
}
