package com.myproject.poc.loan_banking.loan;

import com.myproject.poc.loan_banking.model.Customer;

public class PersonalLoan extends Loan {

    public PersonalLoan(
            double amount,
            double interestRate,
            int tenureInYears) {

        super(amount, interestRate, tenureInYears);
    }

    @Override
    public boolean isEligible(Customer customer) {

        return customer.monthlyIncome() >= 30000 && customer.creditScore() >= 650;
    }
}
