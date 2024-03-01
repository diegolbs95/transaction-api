package com.transaction.usercase.dto;

import com.transaction.infra.enums.UserType;

public record UserDto(String nome,
                      String email,
                      UserType userType,
                      String cpfCnpj) {
}
