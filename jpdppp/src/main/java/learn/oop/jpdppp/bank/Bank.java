package learn.oop.jpdppp.bank;

import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Bank is responsible for managing of several bank accounts.
 */
public class Bank implements Iterable<BankAccount> {
    /** Map of accounts where key denotes the account number and value is a bank account. */
    private final Map<Integer, BankAccount> accounts;
    private int nextAcct;

    public Bank(Map<Integer, BankAccount> accounts, int nextAcct) {
        this.accounts = accounts;
        this.nextAcct = nextAcct;
    }

    /** Allocates a new account number, and assigns it to the map with an initial balance of 0. */
    public int newAccount(int type, boolean isForeign) {
        int acctNum = nextAcct++;
        BankAccount bankAccount = AccountFactory.createAccount(type, acctNum);
        bankAccount.setForeign(isForeign);
        accounts.put(bankAccount.getAcctNum(), bankAccount);
        return acctNum;
    }

    /** Allocates a new account number, and assigns it to the map with an initial balance of 0. */
    public int newAccount() {
        return newAccount(1, false);
    }

    public int getBalance(int acctNum) {
        BankAccount bankAccount = accounts.get(acctNum);
        return bankAccount.getBalance();
    }

    /** Increases the balance of the specified account by a specified number of cents. */
    public void deposit(int acctNu, int amount) {
        BankAccount bankAccount = accounts.get(acctNu);
        bankAccount.deposit(amount);
    }

    /** Determines whether the specified account has enough money to be used as collateral for a loan.
     * The criterion is that the account must contain at least half of the loan amount. */
    public boolean authorizeLoan(int acctNum, int loan) {
        BankAccount bankAccount = accounts.get(acctNum);
        return bankAccount.hasEnoughCollateral(loan);
    }

    /** Sets <code>foreign</code> property of the specified account. */
    public void setForeign(int acctNum, boolean isForeign) {
        BankAccount bankAccount = accounts.get(acctNum);
        bankAccount.setForeign(isForeign);
    }

    /** Increases the balance of savings accounts by a fixed interest rate. */
    public void addInterest() {
        for (BankAccount bankAccount : accounts.values()) {
            bankAccount.addInterest();
        }
    }

    /** Returns string representation that contains balance of every account. */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("The bank has ").append(accounts.size()).append(" accounts");
        for (BankAccount ba : accounts.values()) {
            result.append("\n\t");
            result.append(ba.toString());
        }
        return result.toString();
    }

    public int nextAcctNum() {
        return nextAcct;
    }

    @Override
    public Iterator<BankAccount> iterator() {
        return accounts.values().iterator();
    }

    public Stream<BankAccount> stream() {
        return accounts.values().stream();
    }
}
