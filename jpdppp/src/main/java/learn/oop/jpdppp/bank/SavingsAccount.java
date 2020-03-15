package learn.oop.jpdppp.bank;

public class SavingsAccount extends AbstractBankAccount {
    private static final double RATE = 0.01;

    public SavingsAccount(int acctNum) {
        super(acctNum);
    }

    @Override
    public boolean hasEnoughCollateral(int loan) {
        return balance >= loan / 2.0;
    }

    @Override
    public void addInterest() {
        balance += (int) (balance * RATE);
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
    public String toString() {
        return "SavingsAccount " + acctNum + ": balance=" + balance + ", is " + (isForeign() ? "foreign" : "domestic");
    }
}
