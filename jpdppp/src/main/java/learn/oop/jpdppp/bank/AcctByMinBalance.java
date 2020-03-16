package learn.oop.jpdppp.bank;

import java.util.Comparator;

/** Compares accounts by balances from high to low. */
public class AcctByMinBalance implements Comparator<BankAccount> {
    @Override
    public int compare(BankAccount b1, BankAccount b2) {
        int rst = b2.getBalance() - b1.getBalance();
        return rst != 0 ? rst : b1.getAcctNum() - b2.getAcctNum();
    }
}
