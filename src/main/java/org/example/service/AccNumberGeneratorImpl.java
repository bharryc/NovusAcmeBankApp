package org.example.service;

import java.util.Random;
import java.util.Set;
import java.util.HashSet;

public class AccNumberGeneratorImpl implements AccNumberGenerator {
    private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int NUM_LETTERS = 3;
    private static final int NUM_DIGITS = 6;

    private Set<String> generatedNumbers = new HashSet<>();

    @Override
    public String generateNumber() {
        String accountNumber;
        do {
            accountNumber = generateUniqueAccountNumber();
        } while (!isUnique(accountNumber));

        generatedNumbers.add(accountNumber);
        return accountNumber;
    }

    private String generateUniqueAccountNumber() {
        StringBuilder accountNumber = new StringBuilder();

        // Generate 6 random digits
        Random random = new Random();
        for (int i = 0; i < NUM_DIGITS; i++) {
            int digit = random.nextInt(10);
            accountNumber.append(digit);
        }

        // Generate 3 random letters
        for (int i = 0; i < NUM_LETTERS; i++) {
            int index = random.nextInt(LETTERS.length());
            char letter = LETTERS.charAt(index);
            accountNumber.append(letter);
        }

        return accountNumber.toString();
    }

    private boolean isUnique(String accountNumber) {
        return !generatedNumbers.contains(accountNumber);
    }
}
