import com.myproject.loan_banking.loan.HomeLoan;
import com.myproject.loan_banking.loan.Loan;
import com.myproject.loan_banking.loan.PersonalLoan;
import com.myproject.loan_banking.loan.VehicleLoan;
import com.myproject.loan_banking.model.Customer;
import com.myproject.loan_banking.model.LoanApplication;

void main() {

    Customer customer =
            new Customer("Visper", 80_000, 750);

    Loan[] loans = {
            new HomeLoan(4_000_000, 8.5, 20, 5_000_000),
            new PersonalLoan(1_000_000, 12, 5),
            new VehicleLoan(1_500_000, 9, 7, 1_700_000)
    };

    for (Loan loan : loans) {

        System.out.println("--------------------");

        LoanApplication application =
                new LoanApplication(customer, loan);

        application.processApplication();
    }
}
