package learn.oop.jpdppp.bank.iterators;

import learn.oop.jpdppp.bank.Bank;
import learn.oop.jpdppp.bank.BankAccount;

import java.util.function.Predicate;

/**
 * Illustrates the use of several <code>Stream</code> methods.
 */
public class StreamAccountStats {
    private final Bank bank;

    public StreamAccountStats(Bank bank) {
        this.bank = bank;
    }

    public void printAccounts7(Predicate<BankAccount> predicate) {
        bank.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }

    public int maxBalance4(Predicate<BankAccount> predicate) {
        return bank.stream()
                .filter(predicate)
                .map(BankAccount::getBalance)
                .reduce(0, Math::max);
    }
}
