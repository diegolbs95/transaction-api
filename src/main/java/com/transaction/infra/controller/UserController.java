package com.transaction.infra.controller;

import com.transaction.usercase.dto.UserDto;

public interface UserController {

    String register(UserDto userDto);
}
