package com.myproject.loan_banking.model;

import com.myproject.loan_banking.loan.Loan;

public record LoanApplication(Customer customer, Loan loan) {

    public void processApplication() {

        System.out.println("Customer: " + customer.name());
        System.out.println("Loan Type: " + loan.getClass().getSimpleName());
        System.out.println("Loan Amount: " + loan.getAmount());

        if (loan.isEligible(customer)) {

            System.out.println("Status: APPROVED");

            System.out.printf(
                    "EMI: %.2f%n",
                    loan.calculateEMI()
            );

            System.out.printf(
                    "Interest Rate: %.2f%%%n",
                    loan.getInterestRate()
            );

            System.out.printf(
                    "Tenure: %d years%n",
                    loan.getTenureInYears()
            );

        } else {

            System.err.println("Status: REJECTED");
        }
    }
}
