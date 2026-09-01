package com.myproject.loan_banking.loan;

import com.myproject.loan_banking.model.Customer;

public class HomeLoan extends Loan {

    private final double propertyValue;

    public HomeLoan(
            double amount,
            double interestRate,
            int tenureInYears,
            double propertyValue) {

        super(amount, interestRate, tenureInYears);
        this.propertyValue = propertyValue;
    }

    @Override
    public boolean isEligible(Customer customer) {

        return customer.monthlyIncome() >= 50000
                && customer.creditScore() >= 700
                && getAmount() <= propertyValue * 0.8;
    }
}
