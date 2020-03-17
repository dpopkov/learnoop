package learn.oop.jpdppp.bank;

public class RegularCheckingFactory implements AccountFactory {
    @Override
    public BankAccount create(int acctNum) {
        return new RegularChecking(acctNum);
    }
}
