package learn.oop.jpdppp.bank;

public class InterestChecking extends CheckingAccount {
    private static final double RATE = 0.01;

    @Override
    public double interestRate() {
        return RATE;
    }

    @Override
    public String accountType() {
        return "Interest Checking";
    }
}
