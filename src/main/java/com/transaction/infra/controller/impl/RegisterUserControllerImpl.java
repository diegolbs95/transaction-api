package com.transaction.infra.controller.impl;

import com.transaction.infra.controller.RegisterUserController;
import com.transaction.usercase.dto.UserDto;
import com.transaction.usercase.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class RegisterUserControllerImpl implements RegisterUserController {

    private final UserService userService;

    @Override
    @PostMapping("/register")
    public UserDto register(UserDto userDto) {

        return userService.registerUser(userDto);
    }
}
