package learn.oop.jpdppp.bank;

public interface AccountFactory {
    BankAccount create(int acctNum);

    AccountFactory[] factories = {
            new SavingsFactory(),
            new RegularCheckingFactory(),
            new InterestCheckingFactory()
    };

    static BankAccount createAccount(int type, int acctNum) {
        AccountFactory factory = factories[type - 1];
        return factory.create(acctNum);
    }
}
