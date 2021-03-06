package learn.oop.jpdppp.bank;

import learn.oop.jpdppp.bank.adapters.Loan;
import learn.oop.jpdppp.bank.decorators.LoanAuthorizer;
import learn.oop.jpdppp.bank.decorators.SuspiciousAccount;
import learn.oop.jpdppp.bank.decorators.UnmodifiableBankIterator;

import java.util.*;
import java.util.stream.Stream;

/**
 * Bank is responsible for managing of several bank accounts.
 */
public class Bank implements Iterable<BankAccount> {
    /** Map of accounts where key denotes the account number and value is a bank account. */
    private final Map<Integer, BankAccount> accounts;
    private int nextAcct;
    private final Map<BankEvent, List<BankObserver>> observers = new EnumMap<>(BankEvent.class);

    public Bank(Map<Integer, BankAccount> accounts, int nextAcct) {
        this.accounts = accounts;
        this.nextAcct = nextAcct;
        for (BankEvent e : BankEvent.values()) {
            observers.put(e, new ArrayList<>());
        }
    }

    public void addObserver(BankEvent event, BankObserver observer) {
        observers.get(event).add(observer);
    }

    public void notifyObservers(BankEvent event, BankAccount account, int depositAmount) {
        for (BankObserver observer : observers.get(event)) {
            observer.update(event, account, depositAmount);
        }
    }

    /** Allocates a new account number, and assigns it to the map with an initial balance of 0. */
    public int newAccount(int type, boolean isForeign) {
        int acctNum = nextAcct++;
        BankAccount bankAccount = AccountFactory.createAccount(type, acctNum);
        bankAccount.setForeign(isForeign);
        accounts.put(bankAccount.getAcctNum(), bankAccount);
        notifyObservers(BankEvent.NEW, bankAccount, 0);
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
        notifyObservers(BankEvent.DEPOSIT, bankAccount, amount);
    }

    /** Determines whether the specified account has enough money to be used as collateral for a loan. */
    public boolean authorizeLoan(int acctNum, int loan) {
        BankAccount bankAccount = accounts.get(acctNum);
        LoanAuthorizer auth = LoanAuthorizer.getAuthorizer(bankAccount);
        return auth.authorizeLoan(loan);
    }

    /** Sets <code>foreign</code> property of the specified account. */
    public void setForeign(int acctNum, boolean isForeign) {
        BankAccount bankAccount = accounts.get(acctNum);
        bankAccount.setForeign(isForeign);
        notifyObservers(BankEvent.SET_FOREIGN, bankAccount, 0);
    }

    public boolean isForeign(int acctNum) {
        BankAccount bankAccount = accounts.get(acctNum);
        return bankAccount.isForeign();
    }

    /** Increases the balance of savings accounts by a fixed interest rate. */
    public void addInterest() {
        for (BankAccount bankAccount : accounts.values()) {
            bankAccount.addInterest();
        }
        notifyObservers(BankEvent.INTEREST, null, 0);
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
        return new UnmodifiableBankIterator(accounts.values().iterator());
    }

    public Stream<BankAccount> stream() {
        return accounts.values().stream();
    }

    public Loan[] loans() {
        // This is empty implementation just for referencing in FIClient
        return new Loan[0];
    }

    public void makeSuspicious(int accountNumber) {
        BankAccount account = accounts.get(accountNumber);
        BankAccount wrapped = new SuspiciousAccount(account);
        accounts.put(accountNumber, wrapped);
    }
}
