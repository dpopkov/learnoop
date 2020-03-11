package learn.oop.jpdppp.bank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class BankProgram {
    /** Map of accounts where key denotes the account number and value is the balance in cents. */
    private final Map<Integer, Integer> accounts = new HashMap<>();
    private final double rate = 0.01;
    private int nextAcct = 0;
    private int current = -1;
    private Scanner scanner;
    private boolean done = false;

    private void run() {
        scanner = new Scanner(System.in);
        while (!done) {
            System.out.print("Enter command (0=quit, 1=new, 2=select, 3=deposit, 4=loan, 5=show, 6=interest): ");
            int cmd = scanner.nextInt();
            processCommand(cmd);
        }
        scanner.close();
    }

    private void processCommand(int cmd) {
        if (cmd == 0) {
            quit();
        } else if (cmd == 1) {
            newAccount();
        } else if (cmd == 2) {
            select();
        } else if (cmd == 3) {
            deposit();
        } else if (cmd == 4) {
            authorizeLoan();
        } else if (cmd == 5) {
            showAll();
        } else if (cmd == 6) {
            addInterest();
        } else {
            System.out.println("Illegal command.");
        }
    }

    /** Terminates the loop. */
    private void quit() {
        done = true;
        System.out.println("Bye!");
    }

    /** Allocates a new account number, makes it current, and assigns it to the map with an initial balance of 0. */
    private void newAccount() {
        current = nextAcct++;
        accounts.put(current, 0);
        System.out.println("Your new account number is " + current);
    }

    /** Makes an existing account current and prints the account balance. */
    private void select() {
        System.out.print("Enter account #: ");
        current = scanner.nextInt();
        int balance = accounts.get(current);
        System.out.printf("The balance of account %d is %d%n", current, balance);
    }

    /** Increases the balance of the current account by a specified number of cents. */
    private void deposit() {
        System.out.print("Enter deposit amount: ");
        int amt = scanner.nextInt();
        int balance = accounts.get(current);
        accounts.put(current, balance + amt);
    }

    /** Determines whether the current account has enough money to be used as collateral for a loan.
     * The criterion is that the account must contain at least half of the loan amount. */
    private void authorizeLoan() {
        System.out.print("Enter loan amount: ");
        int loan = scanner.nextInt();
        int balance = accounts.get(current);
        if (balance >= loan / 2) {
            System.out.println("Your loan is approved");
        } else {
            System.out.println("Your loan is denied");
        }
    }

    /** Prints the balance of every account. */
    private void showAll() {
        Set<Integer> acctNumbers = accounts.keySet();
        System.out.println("The bank has " + acctNumbers.size() + " accounts");
        for (int i : acctNumbers) {
            System.out.println("\tBank account " + i + ": balance=" + accounts.get(i));
        }
    }

    /** Increases the balance of each account by a fixed interest rate. */
    private void addInterest() {
        Set<Integer> acctNumbers = accounts.keySet();
        for (int i : acctNumbers) {
            int balance = accounts.get(i);
            int newBalance = (int) (balance * (1 + rate));
            accounts.put(i, newBalance);
        }
    }

    public static void main(String[] args) {
        BankProgram program = new BankProgram();
        program.run();
    }
}
