package learn.oop.jpdppp.bank.decorators;

import learn.oop.jpdppp.bank.BankAccount;

import java.util.Iterator;

public class UnmodifiableBankIterator implements Iterator<BankAccount> {
    private final Iterator<BankAccount> iterator;

    public UnmodifiableBankIterator(Iterator<BankAccount> iterator) {
        this.iterator = iterator;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public BankAccount next() {
        return new UnmodifiableAccount(iterator.next());
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
