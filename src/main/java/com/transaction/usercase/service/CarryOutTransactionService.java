package com.transaction.usercase.service;

import com.transaction.infra.exception.PayerOrBeneficiaryDoesNotExistException;
import com.transaction.infra.persistence.domain.User;
import com.transaction.infra.persistence.repository.UserRepository;
import com.transaction.usercase.dto.TransactionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarryOutTransactionService {

    private final UserRepository repository;

    public String carryOutTransaction(TransactionRequest request){
        return null;
    }

    private User findByUserOrCpfCnpj(String cpfCnpj){
        return repository.findByCpfCnpj(cpfCnpj)
                .orElseThrow(() -> new PayerOrBeneficiaryDoesNotExistException("User not found with CPF or CNPJ."));
    }
}
