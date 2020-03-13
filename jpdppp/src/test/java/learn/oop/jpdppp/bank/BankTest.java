package learn.oop.jpdppp.bank;

import org.junit.Test;

import static org.junit.Assert.*;

public class BankTest {
    private final Bank bank = new Bank();

    @Test
    public void whenNewAccountThenCreatesNew() {
        int acct1 = bank.newAccount();
        assertEquals(0, acct1);
        int acct2 = bank.newAccount();
        assertEquals("Non expected account number",1, acct2);
    }

    @Test
    public void whenDepositThenAddsAmount() {
        int acct1 = bank.newAccount();
        bank.deposit(acct1, 100);
        int balance = bank.getBalance(acct1);
        assertEquals("Non expected balance", 100, balance);
        bank.deposit(acct1, 20);
        balance = bank.getBalance(acct1);
        assertEquals("Non expected total balance", 120, balance);
    }

    @Test
    public void whenAuthorizeLoanThenAuthorizesTwoTimesBigger() {
        int acct1 = bank.newAccount();
        bank.deposit(acct1, 100);
        boolean approved = bank.authorizeLoan(acct1, 200);
        assertTrue("Non expected loan rejection", approved);
        approved = bank.authorizeLoan(acct1, 201);
        assertFalse("Non expected loan authorization", approved);
    }
}
