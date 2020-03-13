package learn.oop.jpdppp.bank;

public class BankAccount {
    private static final double RATE = 0.01;

    private final int acctNum;
    private int balance = 0;
    private boolean isForeign = false;

    public BankAccount(int acctNum) {
        this.acctNum = acctNum;
    }

    public int getAcctNum() {
        return acctNum;
    }

    public int getBalance() {
        return balance;
    }

    public boolean isForeign() {
        return isForeign;
    }

    public void setForeign(boolean foreign) {
        isForeign = foreign;
    }

    public void deposit(int amt) {
        balance = balance + amt;
    }

    public boolean hasEnoughCollateral(int loan) {
        return balance >= loan / 2.0;
    }

    public void addInterest() {
        balance = balance + (int) (balance * RATE);
    }

    @Override
    public String toString() {
        return "BankAccount " + acctNum + ": balance=" + balance + ", is " + (isForeign() ? "foreign" : "domestic");
    }
}
