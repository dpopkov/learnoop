package learn.oop.jpdppp.bank;

public class CheckingAccount implements BankAccount {
    private final int acctNum;
    private int balance = 0;
    private boolean isForeign = false;

    public CheckingAccount(int acctNum) {
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
        balance = balance + amt;
    }

    @Override
    public boolean hasEnoughCollateral(int loan) {
        return balance >= 2.0 * loan / 2.0;
    }

    @Override
    public void addInterest() {
        // do nothing
    }

    @Override
    public String toString() {
        return "CheckingAccount " + acctNum + ": balance=" + balance + ", is " + (isForeign() ? "foreign" : "domestic");
    }

    @Override
    public int compareTo(BankAccount other) {
        int cmp = getBalance() - other.getBalance();
        return (cmp != 0) ? cmp : (getAcctNum() - other.getAcctNum());
    }
}
