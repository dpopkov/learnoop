package learn.oop.jpdppp.bank;

public interface AccountFactory {
    BankAccount create(int acctNum);

    AccountFactory[] FACTORIES = AccountFactories.values();

    static BankAccount createAccount(int type, int acctNum) {
        AccountFactory factory = FACTORIES[type - 1];
        return factory.create(acctNum);
    }
}
