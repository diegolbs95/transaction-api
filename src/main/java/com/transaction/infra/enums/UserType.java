package com.transaction.infra.enums;

import lombok.Getter;

@Getter
public enum UserType {

    FISICA(0),
    LOJISTA(1);

    private final Integer code;

    UserType(Integer code) {
        this.code = code;
    }

}