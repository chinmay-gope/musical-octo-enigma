package com.myproject.loan_banking.loan;

import com.myproject.loan_banking.model.Customer;

public abstract class Loan {

    private final double amount;
    private final double interestRate;
    private final int tenureInYears;

    public Loan(double amount, double interestRate, int tenureInYears) {
        this.amount = amount;
        this.interestRate = interestRate;
        this.tenureInYears = tenureInYears;
    }

    /// @param customer The customer for whom to check eligibility
    /// @return true if the customer is eligible for the loan, false otherwise
    public abstract boolean isEligible(Customer customer);

    /**
     * Calculates the Equated Monthly Installment (EMI) for the loan.
     *
     * <p>The EMI is calculated using the formula:</p>
     *
     * <pre>
     *              P * r × (1 + r) <sup>n</sup>
     *     EMI = ----------------------
     *              (1 + r) <sup>n - 1</sup>
     * </pre>
     *
     * <ul>
     *   <li>{@code P} = loan amount</li>
     *   <li>{@code r} = monthly interest rate ({@code annualRate / 1200})</li>
     *   <li>{@code n} = total number of monthly payments ({@code years × 12})</li>
     * </ul>
     *
     * @return the calculated monthly EMI
     */
    public double calculateEMI() {

        double monthlyRate = interestRate / 1200;
        int months = tenureInYears * 12;

        return amount * monthlyRate * Math.pow(1 + monthlyRate, months) / (Math.pow(1 + monthlyRate, months) - 1);
    }

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
