package com.transaction.infra.enums;

import lombok.Getter;

@Getter
public enum UserType {

    COMMON(0),
    MERCHANT(1);

    private final Integer code;

    UserType(Integer code) {
        this.code = code;
    }

}