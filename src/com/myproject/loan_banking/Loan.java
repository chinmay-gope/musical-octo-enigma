package com.myproject.loan_banking;

public abstract class Loan {

    private final double amount;
    private final double interestRate;
    private final int tenureInYears;

    public Loan(double amount, double interestRate, int tenureInYears) {
        this.amount = amount;
        this.interestRate = interestRate;
        this.tenureInYears = tenureInYears;
    }

    public abstract boolean isEligible(Customer customer);

    public abstract double calculateEMI();

    public double getAmount() {
        return amount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getTenureInYears() {
        return tenureInYears;
    }
}
