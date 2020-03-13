package learn.oop.jpdppp.bank;

public class BankAccount {
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

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean isForeign() {
        return isForeign;
    }

    public void setForeign(boolean foreign) {
        isForeign = foreign;
    }

    @Override
    public String toString() {
        return "BankAccount " + acctNum + ": balance=" + balance + ", is " + (isForeign ? "foreign" : "domestic");
    }
}
