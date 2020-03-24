package learn.oop.jpdppp.bank.iterators;

import learn.oop.jpdppp.bank.Bank;
import learn.oop.jpdppp.bank.BankAccount;

import java.util.function.Predicate;

/**
 * Illustrates the use of several <code>Stream</code> methods.
 */
public class StreamStatModel {
    private final Bank bank;

    public StreamStatModel(Bank bank) {
        this.bank = bank;
    }

    public String getAccounts7(Predicate<BankAccount> predicate) {
        return bank.stream()
                .filter(predicate)
                .map(Object::toString)
                .reduce("", (s1, s2) -> s1 + s2 + "\n");
    }

    public int maxBalance4(Predicate<BankAccount> predicate) {
        return bank.stream()
                .filter(predicate)
                .map(BankAccount::getBalance)
                .reduce(0, Math::max);
    }
}
