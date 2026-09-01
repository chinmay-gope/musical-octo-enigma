package com.myproject.loan_banking.loan;

import com.myproject.loan_banking.model.Customer;

public class VehicleLoan extends Loan {


    private final double vehiclePrice;

    public VehicleLoan(double amount,
                       double interestRate,
                       int tenureInYears, double vehiclePrice) {

        super(amount, interestRate, tenureInYears);
        this.vehiclePrice = vehiclePrice;
    }

    @Override
    public boolean isEligible(Customer customer) {

        return customer.monthlyIncome() >= 25000
                && customer.creditScore() >= 650
                && getAmount() <= vehiclePrice * 0.9;
    }
}
