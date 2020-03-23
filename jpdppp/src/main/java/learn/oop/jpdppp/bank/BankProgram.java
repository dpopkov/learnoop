package learn.oop.jpdppp.bank;

import java.util.Map;
import java.util.Scanner;

public class BankProgram {
    private static final int SUSPICIOUS_AMOUNT_IN_CENTS = 100_000_00;

    public static void main(String[] args) {
        SavedBankInfo info = new SavedBankInfo("data/bank18.info.ser");
        Map<Integer, BankAccount> accounts = info.getAccounts();
        int nextAcct = info.nextAcctNum();
        Bank bank = new Bank(accounts, nextAcct);
        BankObserver auditor = new Auditor(bank);
        bank.addObserver(BankEvent.DEPOSIT, (event, ba, amt) -> {
            if (amt > SUSPICIOUS_AMOUNT_IN_CENTS) {
                bank.makeSuspicious(ba.getAcctNum());
            }
        });
        Scanner scanner = new Scanner(System.in);
        BankClient client = new BankClient(scanner, bank);
        client.run();
        info.saveMap(accounts, bank.nextAcctNum());
    }
}
