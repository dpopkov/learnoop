package learn.oop.jpdppp.bank;

public class InterestChecking extends CheckingAccount {
    private static final double RATE = 0.01;

    public InterestChecking(int acctNum) {
        super(acctNum);
    }

    @Override
    public void addInterest() {
        balance += (int) (getBalance() * RATE);
    }

    @Override
    public String toString() {
        return "Interest checking account "
                + getAcctNum() + ": balance=" + getBalance() + ", is " + (isForeign() ? "foreign" : "domestic");
    }
}
