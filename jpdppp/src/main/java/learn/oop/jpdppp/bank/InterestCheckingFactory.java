package learn.oop.jpdppp.bank;

public class InterestCheckingFactory implements AccountFactory {
    @Override
    public BankAccount create(int acctNum) {
        return new InterestChecking(acctNum);
    }
}
