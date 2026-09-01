package com.myproject.loan_banking;

public class LoanApplication {

    private final Customer customer;
    private final Loan loan;

    public LoanApplication(Customer customer, Loan loan) {
        this.customer = customer;
        this.loan = loan;
    }

    public void processApplication() {

        System.out.println("Customer: " + customer.name());
        System.out.println("Loan Amount: " + loan.getAmount());

        if (loan.isEligible(customer)) {

            System.out.println("Status: APPROVED");

            System.out.printf(
                    "Monthly EMI: %.2f%n",
                    loan.calculateEMI()
            );

        } else {

            System.err.println("Status: REJECTED");
        }
    }
}
