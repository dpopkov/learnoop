package learn.oop.jpdppp.bank;

import java.io.Serializable;

public interface BankAccount extends Comparable<BankAccount>, Serializable {
    int getAcctNum();
    int getBalance();
    boolean isForeign();
    void setForeign(boolean foreign);
    void deposit(int amt);
    boolean hasEnoughCollateral(int loan);
    void addInterest();
    int fee();
}
