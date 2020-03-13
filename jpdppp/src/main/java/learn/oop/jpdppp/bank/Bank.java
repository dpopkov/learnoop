package learn.oop.jpdppp.bank;

import java.util.HashMap;
import java.util.Map;

/**
 * Bank is responsible for the banking information.
 */
public class Bank {
    private static final double RATE = 0.01;

    /** Map of accounts where key denotes the account number and value is the balance in cents. */
    private final Map<Integer, BankAccount> accounts = new HashMap<>();
    private int nextAcct = 0;

    /** Allocates a new account number, and assigns it to the map with an initial balance of 0. */
    public int newAccount(boolean isForeign) {
        int acctNum = nextAcct++;
        BankAccount bankAccount = new BankAccount(acctNum);
        bankAccount.setForeign(isForeign);
        accounts.put(acctNum, bankAccount);
        return acctNum;
    }

    /** Allocates a new account number, and assigns it to the map with an initial balance of 0. */
    public int newAccount() {
        return newAccount(false);
    }

    public int getBalance(int acctNum) {
        BankAccount bankAccount = accounts.get(acctNum);
        return bankAccount.getBalance();
    }

    /** Increases the balance of the specified account by a specified number of cents. */
    public void deposit(int acctNu, int amount) {
        BankAccount bankAccount = accounts.get(acctNu);
        int balance = bankAccount.getBalance();
        bankAccount.setBalance(balance + amount);
    }

    /** Determines whether the specified account has enough money to be used as collateral for a loan.
     * The criterion is that the account must contain at least half of the loan amount. */
    public boolean authorizeLoan(int acctNum, int loan) {
        BankAccount bankAccount = accounts.get(acctNum);
        int balance = bankAccount.getBalance();
        return balance >= loan / 2.0;
    }

    /** Sets <code>foreign</code> property of the specified account. */
    public void setForeign(int acctNum, boolean isForeign) {
        BankAccount bankAccount = accounts.get(acctNum);
        bankAccount.setForeign(isForeign);
    }

    /** Increases the balance of each account by a fixed interest rate. */
    public void addInterest() {
        for (BankAccount bankAccount : accounts.values()) {
            int balance = bankAccount.getBalance();
            int newBalance = balance + (int) (balance * RATE);
            bankAccount.setBalance(newBalance);
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
}
