package learn.oop.jpdppp.bank.adapters;

import learn.oop.jpdppp.bank.Bank;
import learn.oop.jpdppp.bank.BankAccount;
import learn.oop.jpdppp.bank.SavedBankInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FIClient {
    public static void main(String[] args) {
        Bank bank = getBank();
        List<FIAccountInfo> info = new ArrayList<>();
        for (BankAccount account : bank) {
            info.add(new BankAccountAdapter(account));
        }
        for (Loan loan : bank.loans()) {
            info.add(new LoanAdapter(loan));
        }
        // Process the list
        int count = 0;
        for (FIAccountInfo a : info) {
            if (a.isForeign() & a.balance() > 1000.0) {
                count++;
            }
        }
        System.out.println("The count is " + count);
    }

    private static Bank getBank() {
        SavedBankInfo savedBank = new SavedBankInfo("data/bank16.info");
        Map<Integer, BankAccount> accounts = savedBank.getAccounts();
        int nextAccount = savedBank.nextAcctNum();
        return new Bank(accounts, nextAccount);
    }
}
