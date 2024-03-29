package com.transaction.infra.factory;

import com.transaction.infra.persistence.domain.User;
import com.transaction.usercase.dto.UserDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserFactory {

    public static User userFactory(UserDto userDto){
        return User.builder()
                .email(userDto.email())
                .nome(userDto.nome())
                .userType(userDto.userType())
                .cpfCnpj(userDto.cpfCnpj())
                .build();
    }
}
