package com.transaction.infra.enums;

public enum UserEnum {

    FISICA(0),
    JURIDICA(1);

    private final Integer descricao;

    UserEnum(Integer descricao) {
        this.descricao = descricao;
    }
}
