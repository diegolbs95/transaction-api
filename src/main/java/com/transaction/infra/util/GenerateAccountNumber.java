package com.transaction.infra.util;

import lombok.experimental.UtilityClass;

import java.util.Random;

@UtilityClass
public class GenerateAccountNumber {

    public static String generateAccountNumber() {
        var random = new Random();
        var numberAccount = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            numberAccount.append(random.nextInt(10));
        }
        return numberAccount.toString();
    }
}
