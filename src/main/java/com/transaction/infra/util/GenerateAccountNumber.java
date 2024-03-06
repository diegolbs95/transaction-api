package com.transaction.infra.util;

import lombok.experimental.UtilityClass;

import java.util.Random;

@UtilityClass
public class GenerateAccountNumber {

    private static final Random RANDOM = new Random();

    public static String generateAccountNumber() {
        var numberAccount = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            numberAccount.append(RANDOM.nextInt(10));
        }
        return numberAccount.toString();
    }
}
