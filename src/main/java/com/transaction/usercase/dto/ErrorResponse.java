package com.transaction.usercase.dto;

import org.springframework.http.HttpStatus;

public record ErrorResponse(HttpStatus code,
                            String message) {
}
