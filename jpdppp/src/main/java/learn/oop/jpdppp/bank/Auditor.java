package learn.oop.jpdppp.bank;

public class Auditor implements BankObserver {
    public Auditor(Bank bank) {
        bank.addObserver(BankEvent.NEW, this);
        bank.addObserver(BankEvent.SET_FOREIGN, this);
    }

    @Override
    public void update(BankEvent event, BankAccount account, int depositAmount) {
        if (account.isForeign()) {
            if (event == BankEvent.NEW) {
                System.out.println("New foreign account " + account.getAcctNum());
            } else if (event == BankEvent.SET_FOREIGN) {
                System.out.println("Modified foreign account: " + account.getAcctNum());
            }
        }
    }
}
