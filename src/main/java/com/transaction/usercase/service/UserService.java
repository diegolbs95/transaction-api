package com.transaction.usercase.service;

import com.transaction.infra.persistence.repository.UserRepository;
import com.transaction.usercase.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.transaction.infra.factory.UserFactory.userFactory;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public UserDto registerUser(UserDto userDto) {
        repository.save(userFactory(userDto));
        return userDto;
    }
}
