package com.transaction.usercase.dto;

import org.springframework.http.HttpStatus;

public record ErrorResponseDTO(HttpStatus code,
                               String message) {
}
