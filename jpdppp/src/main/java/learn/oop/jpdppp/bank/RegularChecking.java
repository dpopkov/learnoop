package learn.oop.jpdppp.bank;

public class RegularChecking extends CheckingAccount {
    public RegularChecking(int acctNum) {
        super(acctNum);
    }

    @Override
    public double interestRate() {
        return 0.0;
    }

    @Override
    protected String accountType() {
        return "Regular Checking";
    }
}
