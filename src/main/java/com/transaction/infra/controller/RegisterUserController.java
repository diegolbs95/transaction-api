package com.transaction.infra.controller;

import com.transaction.usercase.dto.UserDto;

public interface RegisterUserController {

    String register(UserDto userDto);
}
