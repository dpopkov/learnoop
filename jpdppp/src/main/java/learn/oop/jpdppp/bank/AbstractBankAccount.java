package learn.oop.jpdppp.bank;

public abstract class AbstractBankAccount implements BankAccount {
    protected final int acctNum;
    protected int balance = 0;
    protected boolean isForeign = false;

    protected AbstractBankAccount(int acctNum) {
        this.acctNum = acctNum;
    }

    @Override
    public int getAcctNum() {
        return acctNum;
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public boolean isForeign() {
        return isForeign;
    }

    @Override
    public void setForeign(boolean foreign) {
        isForeign = foreign;
    }

    @Override
    public void deposit(int amt) {
        balance += amt;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof BankAccount)) {
            return false;
        }
        BankAccount ba = (BankAccount) obj;
        return getAcctNum() == ba.getAcctNum();
    }

    @Override
    public int compareTo(BankAccount other) {
        int cmp = getBalance() - other.getBalance();
        return (cmp != 0) ? cmp : (getAcctNum() - other.getAcctNum());
    }

    @Override
    public abstract boolean hasEnoughCollateral(int loan);

    @Override
    public abstract void addInterest();

    @Override
    public abstract String toString();
}
