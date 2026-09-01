package com.myproject.loan_banking;

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

    @Override
    public double calculateEMI() {
        double monthlyRate = getInterestRate() / 1200;
        int months = getTenureInYears() * 12;

        return getAmount() * monthlyRate *
                Math.pow(1 + monthlyRate, months)
                / (Math.pow(1 + monthlyRate, months) - 1);
    }
}
