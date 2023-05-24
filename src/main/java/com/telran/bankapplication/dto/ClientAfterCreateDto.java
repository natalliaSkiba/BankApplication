package com.telran.bankapplication.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.telran.bankapplication.entity.Account;
import com.telran.bankapplication.entity.Manager;
import com.telran.bankapplication.entity.enums.ClientStatus;
import jakarta.persistence.*;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.CascadeType.REFRESH;

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
