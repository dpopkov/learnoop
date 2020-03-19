package learn.oop.jpdppp.bank.iterators;

import learn.oop.jpdppp.bank.Bank;
import learn.oop.jpdppp.bank.BankAccount;

import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class IteratorAccountStats {
    private final Bank bank;

    public IteratorAccountStats(Bank bank) {
        this.bank = bank;
    }

    @SuppressWarnings("WhileLoopReplaceableByForEach")
    public void printAccounts1() {
        Iterator<BankAccount> it = bank.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public void printAccounts2() {
        for (BankAccount a : bank) {
            System.out.println(a);
        }
    }

    public void printAccounts3() {
        bank.forEach(System.out::println);
    }

    public void visit1(Consumer<BankAccount> action) {
        bank.forEach(action);
    }

    public int maxBalance1() {
        int max = 0;
        for (BankAccount a : bank) {
            int balance = a.getBalance();
            if (balance > max) {
                max = balance;
            }
        }
        return max;
    }

    public int maxBalance3a() {
        Visitor<BankAccount, Integer> visitor = new MaxBalanceVisitor();
        bank.forEach(visitor);
        return visitor.result();
    }

    public <R> R visit2(Visitor<BankAccount, R> action) {
        bank.forEach(action);
        return action.result();
    }

    public int maxBalance3c() {
        return visit2(new MaxBalanceVisitor());
    }

    public void printAccounts4(Predicate<BankAccount> predicate) {
        for (BankAccount a : bank) {
            if (predicate.test(a)) {
                System.out.println(a);
            }
        }
    }

    public int maxBalance4(Predicate<BankAccount> predicate) {
        int max = 0;
        for (BankAccount a : bank) {
            if (predicate.test(a)) {
                int balance = a.getBalance();
                if (balance > max) {
                    max = balance;
                }
            }
        }
        return max;
    }

    public void printAccounts5(Predicate<BankAccount> predicate) {
        Consumer<BankAccount> action = a -> {
            if (predicate.test(a)) {
                System.out.println(a);
            }
        };
        bank.forEach(action);
    }

    public int maxBalance5(Predicate<BankAccount> filterPredicate) {
        Visitor<BankAccount, Integer> visitor = new MaxBalanceVisitor();
        Consumer<BankAccount> accountConsumer = account -> {
            if (filterPredicate.test(account)) {
                visitor.accept(account);
            }
        };
        bank.forEach(accountConsumer);
        return visitor.result();
    }

    public void visit3(Predicate<BankAccount> predicate, Consumer<BankAccount> consumer) {
        bank.forEach(a -> {
            if (predicate.test(a)) {
                consumer.accept(a);
            }
        });
    }

    public <R> R visit4(Predicate<BankAccount> predicate, Visitor<BankAccount, R> visitor) {
        bank.forEach(a -> {
            if (predicate.test(a)) {
                visitor.accept(a);
            }
        });
        return visitor.result();
    }
}
