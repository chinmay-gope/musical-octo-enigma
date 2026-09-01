package com.myproject.loan_banking;

public record Customer(
        String name,
        double monthlyIncome,
        int creditScore
) {
}
