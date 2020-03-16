package learn.oop.jpdppp.bank;

public class InterestChecking extends CheckingAccount {
    private static final double RATE = 0.01;

    public InterestChecking(int acctNum) {
        super(acctNum);
    }

    @Override
    public double interestRate() {
        return RATE;
    }

    @Override
    protected String accountType() {
        return "Interest Checking";
    }
}
