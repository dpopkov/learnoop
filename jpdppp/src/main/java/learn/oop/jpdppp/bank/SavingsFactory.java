package learn.oop.jpdppp.bank;

public class SavingsFactory implements AccountFactory {
    @Override
    public BankAccount create(int acctNum) {
        return new SavingsAccount(acctNum);
    }
}
