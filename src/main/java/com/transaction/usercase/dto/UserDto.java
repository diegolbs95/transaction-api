package com.transaction.usercase.dto;

import com.transaction.infra.enums.UserEnum;

public record UserDto(String nome,
                      String email,
                      UserEnum userEnum,
                      String cpfCnpj) {
}
