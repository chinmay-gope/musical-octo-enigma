package com.myproject.loan_banking.model;

public record Customer(
        String name,
        double monthlyIncome,
        int creditScore
) {
}
