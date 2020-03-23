package learn.oop.jpdppp.bank;

public interface BankObserver {
    void update(BankEvent event, BankAccount account, int depositAmount);
}
