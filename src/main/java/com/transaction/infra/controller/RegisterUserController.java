package com.transaction.infra.controller;

import com.transaction.usercase.dto.UserDto;

public interface RegisterUserController {

    UserDto register(UserDto userDto);
}
