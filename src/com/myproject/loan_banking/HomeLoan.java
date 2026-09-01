package com.myproject.loan_banking;

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

    @Override
    public double calculateEMI() {

        double monthlyRate =
                getInterestRate() / (12 * 100);

        int months = getTenureInYears() * 12;

        return (getAmount() * monthlyRate *
                Math.pow(1 + monthlyRate, months))
                / (Math.pow(1 + monthlyRate, months) - 1);
    }
}
