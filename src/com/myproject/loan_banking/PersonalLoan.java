package com.myproject.loan_banking;

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

    @Override
    public double calculateEMI() {
        double monthlyRate = getInterestRate() / 1200;
        int months = getTenureInYears() * 12;

        return getAmount() * monthlyRate *
                Math.pow(1 + monthlyRate, months)
                / (Math.pow(1 + monthlyRate, months) - 1);
    }
}
