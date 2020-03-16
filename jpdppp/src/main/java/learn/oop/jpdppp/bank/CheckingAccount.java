package learn.oop.jpdppp.bank;

public abstract class CheckingAccount extends AbstractBankAccount {

    protected CheckingAccount(int acctNum) {
        super(acctNum);
    }

    @Override
    protected double collateralRatio() {
        return 2.0 / 3.0;
    }

    @Override
    protected abstract double interestRate();

    @Override
    protected abstract String accountType();
}
