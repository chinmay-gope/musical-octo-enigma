import com.myproject.loan_banking.*;

void main() {

    Customer customer = new Customer("Visper", 80000, 750);

    Loan homeLoan = new HomeLoan(4000000, 8.5, 20, 5000000);

    Loan personalLoan = new PersonalLoan(1000000, 12, 5);

    Loan vehicleLoan = new VehicleLoan(1500000, 9, 7, 1700000);

    Loan[] loans = {homeLoan, personalLoan, vehicleLoan};

    for (Loan loan : loans) {

        System.out.println("--------------------");

        if (loan.isEligible(customer)) {

            System.out.println("APPROVED");

            System.out.printf("EMI: %.2f%n", loan.calculateEMI());

        } else {

            System.out.println("REJECTED");
        }
    }
}
