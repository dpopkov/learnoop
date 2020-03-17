package learn.oop.jpdppp.bank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class SavingsAccountTest {

    @Test
    public void testComparing() {
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(new AbstractBankAccount(0, new SavingsAccount()));
        accounts.get(0).deposit(100);
        accounts.add(new AbstractBankAccount(1, new SavingsAccount()));
        accounts.get(1).deposit(200);
        accounts.add(new AbstractBankAccount(2, new SavingsAccount()));
        accounts.get(2).deposit(50);

        BankAccount max1 = findMax(accounts);
        BankAccount max2 = Collections.max(accounts);
        assertEquals(1, max1.getAcctNum());
        assertEquals(1, max2.getAcctNum());
        BankAccount min = Collections.min(accounts);
        assertEquals(2, min.getAcctNum());
    }

    private BankAccount findMax(List<BankAccount> accounts) {
        BankAccount max = accounts.get(0);
        for (BankAccount sa : accounts) {
            if (sa.compareTo(max) > 0) {
                max = sa;
            }
        }
        return max;
    }
}
