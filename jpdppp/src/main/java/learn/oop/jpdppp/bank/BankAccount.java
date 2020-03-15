package learn.oop.jpdppp.bank;

public interface BankAccount extends Comparable<BankAccount> {
    int getAcctNum();
    int getBalance();
    boolean isForeign();
    void setForeign(boolean foreign);
    void deposit(int amt);
    boolean hasEnoughCollateral(int loan);
    void addInterest();
}