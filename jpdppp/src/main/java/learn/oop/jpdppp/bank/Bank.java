package learn.oop.jpdppp.bank;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Bank is responsible for the banking information.
 */
public class Bank {
    /** Map of accounts where key denotes the account number and value is the balance in cents. */
    private final Map<Integer, Integer> accounts = new HashMap<>();
    private final double rate = 0.01;
    private int nextAcct = 0;

    /** Allocates a new account number, and assigns it to the map with an initial balance of 0. */
    public int newAccount() {
        int acctNum = nextAcct++;
        accounts.put(acctNum, 0);
        return acctNum;
    }

    public int getBalance(int acctNum) {
        return accounts.get(acctNum);
    }

    /** Increases the balance of the specified account by a specified number of cents. */
    public void deposit(int acctNu, int amount) {
        int balance = accounts.get(acctNu);
        accounts.put(acctNu, balance + amount);
    }

    /** Determines whether the specified account has enough money to be used as collateral for a loan.
     * The criterion is that the account must contain at least half of the loan amount. */
    public boolean authorizeLoan(int acctNum, int loan) {
        int balance = accounts.get(acctNum);
        return balance >= loan / 2;
    }

    /** Increases the balance of each account by a fixed interest rate. */
    public void addInterest() {
        Set<Integer> acctNumbers = accounts.keySet();
        for (int i : acctNumbers) {
            int balance = accounts.get(i);
            int newBalance = (int) (balance * (1 + rate));
            accounts.put(i, newBalance);
        }
    }

    /** Returns string representation that contains balance of every account. */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Set<Integer> acctNumbers = accounts.keySet();
        result.append("The bank has ").append(acctNumbers.size()).append(" accounts");
        for (int i : acctNumbers) {
            result.append("\n\tBank account ").append(i).append(": balance=").append(accounts.get(i));
        }
        return result.toString();
    }
}
