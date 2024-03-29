package com.transaction.usercase.service;

import com.transaction.infra.exception.PayerOrBeneficiaryDoesNotExistException;
import com.transaction.infra.persistence.domain.User;
import com.transaction.infra.persistence.repository.UserRepository;
import com.transaction.usercase.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.transaction.infra.factory.UserFactory.userFactory;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final AccountService accountService;

    @Transactional
    public String createUser(UserDto userDto) {

        var user = userFactory(userDto);

        log.info("Account creation request.");
        user.setAccount(accountService.createAccount(userDto.cpfCnpj()));
        log.info("Success when creating user account with CPF/CNPJ: " + userDto.cpfCnpj());

        repository.save(user);
        return "Registered User.";
    }

    public User findByUserOrCpfCnpj(String cpfCnpj){
        return repository.findByCpfCnpj(cpfCnpj)
                .orElseThrow(() -> new PayerOrBeneficiaryDoesNotExistException("User not found with CPF or CNPJ."));
    }
}