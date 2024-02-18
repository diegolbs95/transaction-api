package com.transaction.infra.enums;

public enum UserEnum {

    FISICA(0),
    LOJISTA(1);

    private final Integer code;

    UserEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
