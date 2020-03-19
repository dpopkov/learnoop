package learn.oop.jpdppp.bank.adapters;

public class LoanAdapter implements FIAccountInfo {
    private static final int PENNIES_PER_DOLLAR = 100;

    private final Loan loan;

    public LoanAdapter(Loan loan) {
        this.loan = loan;
    }

    @Override
    public int balance() {
        return (int) (loan.remainingPrincipal() / PENNIES_PER_DOLLAR);
    }

    @Override
    public boolean isForeign() {
        return !loan.isDomestic();
    }

    @Override
    public String accountType() {
        return "loan";
    }
}
