package com.transaction.infra.controller;

import com.transaction.usercase.dto.TransactionRequest;

public interface TransactionController {

    String carryOutTransaction(TransactionRequest request);
}
