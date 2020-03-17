package learn.oop.jpdppp.bank;

public interface AccountFactory {
    BankAccount create(int acctNum);

    AccountFactory[] FACTORIES = {
            new SavingsFactory(),
            new RegularCheckingFactory(),
            new InterestCheckingFactory()
    };

    static BankAccount createAccount(int type, int acctNum) {
        AccountFactory factory = FACTORIES[type - 1];
        return factory.create(acctNum);
    }
}
