package com.transaction.infra.controller;

import com.transaction.usercase.dto.TransactionDTO;

public interface TransactionController {

    String carryOutTransaction(TransactionDTO request);
}
