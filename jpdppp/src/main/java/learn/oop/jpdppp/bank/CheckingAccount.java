package learn.oop.jpdppp.bank;

public abstract class CheckingAccount extends AbstractBankAccount {

    protected CheckingAccount(int acctNum) {
        super(acctNum);
    }

    @Override
    public boolean hasEnoughCollateral(int loan) {
        return balance >= 2.0 * loan / 3.0;
    }

    @Override
    public abstract void addInterest();

    @Override
    public abstract String toString();
}
