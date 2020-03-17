package learn.oop.jpdppp.bank.examples;

import learn.oop.jpdppp.bank.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorBankAccounts {
    public static void main(String[] args) {
        Comparator<BankAccount> minBal = new AcctByMinBalance();
        Comparator<BankAccount> maxBal = innerClassComparator();
        Comparator<BankAccount> minNum = (a1, a2) -> a2.getAcctNum() - a1.getAcctNum();
        Comparator<BankAccount> maxNum = Comparator.comparingInt(BankAccount::getAcctNum);

        List<BankAccount> accounts = initAccounts();
        BankAccount a1 = findMax(accounts, minBal);
        BankAccount a2 = findMax(accounts, maxBal);
        BankAccount a3 = Collections.max(accounts, minNum);
        BankAccount a4 = Collections.max(accounts, maxNum);

        System.out.printf("Account with %s is %s%n", "smallest balance", a1);
        System.out.printf("Account with %s is %s%n", "largest balance", a2);
        System.out.printf("Account with %s is %s%n", "smallest number", a3);
        System.out.printf("Account with %s is %s%n", "largest number", a4);
    }

    @SuppressWarnings("Convert2Lambda")
    private static Comparator<BankAccount> innerClassComparator() {
        return new Comparator<>() {
            @Override
            public int compare(BankAccount a1, BankAccount a2) {
                int rst = a1.getBalance() - a2.getBalance();
                return rst != 0 ? rst : a1.getAcctNum() - a2.getAcctNum();
            }
        };
    }

    private static BankAccount findMax(List<BankAccount> accounts, Comparator<BankAccount> comparator) {
        BankAccount max = accounts.get(0);
        for (int i = 1; i < accounts.size(); i++) {
            BankAccount next = accounts.get(i);
            if (comparator.compare(next, max) > 0) {
                max = next;
            }
        }
        return max;
    }

    private static List<BankAccount> initAccounts() {
        List<BankAccount> list = new ArrayList<>();
        list.add(new AbstractBankAccount(101, new SavingsAccount()));
        list.get(0).deposit(100);
        list.add(new AbstractBankAccount(102, new RegularChecking()));
        list.get(1).deposit(200);
        list.add(new AbstractBankAccount(103, new InterestChecking()));
        list.get(2).deposit(300);
        list.add(new AbstractBankAccount(104, new SavingsAccount()));
        list.get(3).deposit(400);
        return list;
    }
}
