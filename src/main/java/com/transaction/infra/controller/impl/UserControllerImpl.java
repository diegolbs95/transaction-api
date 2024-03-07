package com.transaction.infra.controller.impl;

import com.transaction.infra.controller.UserController;
import com.transaction.usercase.dto.UserDto;
import com.transaction.usercase.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@Log4j2
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Override
    @PostMapping("/create/users")
    @ResponseStatus(CREATED)
    public String createUser(@RequestBody UserDto userDto) {

       log.info("User registration service initialized.");
       var response = userService.createUser(userDto);
       log.info("User registration service completed.");
        return response;
    }
}
