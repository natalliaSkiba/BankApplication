package com.telran.bankapplication.dto;

import java.util.List;

public record ErrorResponseDto(String errorCode, List<ErrorExtensionDto> errorExtensions) {
}
