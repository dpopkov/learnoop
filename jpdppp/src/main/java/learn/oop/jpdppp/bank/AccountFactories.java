package learn.oop.jpdppp.bank;

public enum AccountFactories implements AccountFactory {
    SAVINGS("Savings", SavingsAccount::new),
    REGULAR_CHECKING("Regular checking", RegularChecking::new),
    INTEREST_CHECKING("Interest checking", InterestChecking::new);

    private final String name;
    private final AccountFactory factory;

    AccountFactories(String name, AccountFactory factory) {
        this.name = name;
        this.factory = factory;
    }

    @Override
    public BankAccount create(int acctNum) {
        return factory.create(acctNum);
    }

    @Override
    public String toString() {
        return name;
    }
}
