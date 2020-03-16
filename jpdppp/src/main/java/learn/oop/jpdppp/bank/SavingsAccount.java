package learn.oop.jpdppp.bank;

public class SavingsAccount extends AbstractBankAccount {
    private static final double RATE = 0.01;

    public SavingsAccount(int acctNum) {
        super(acctNum);
    }

    @Override
    protected double collateralRatio() {
        return 0.5;
    }

    @Override
    public double interestRate() {
        return RATE;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof SavingsAccount)) {
            return false;
        }
        SavingsAccount sa = (SavingsAccount) obj;
        return getAcctNum() == sa.getAcctNum();
    }

    @Override
    protected String accountType() {
        return "Savings";
    }
}
