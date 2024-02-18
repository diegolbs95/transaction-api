package com.transaction.infra.controller.impl;

import com.transaction.infra.controller.RegisterUserController;
import com.transaction.usercase.dto.UserDto;
import com.transaction.usercase.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@Log4j2
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class RegisterUserControllerImpl implements RegisterUserController {

    private final UserService userService;

    @Override
    @PostMapping("/register")
    @ResponseStatus(CREATED)
    public String register(UserDto userDto) {

       log.info("User registration service initialized.");
       var response = userService.registerUser(userDto);
       log.info("User registration service completed.");
        return response;
    }
}
