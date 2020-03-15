package learn.oop.jpdppp.bank;

import java.util.Scanner;

/**
 * It is responsible for I/O processing.
 */
public class BankClient {
    private final Bank bank;
    private final Scanner scanner;
    private int current = -1;
    private boolean done = false;

    public BankClient(Scanner scanner, Bank bank) {
        this.scanner = scanner;
        this.bank = bank;
    }

    public void run() {
        while (!done) {
            System.out.print("Enter command (0=quit, 1=new, 2=select, 3=deposit, 4=loan, 5=show, 6=interest, 7=setForeign): ");
            int cmd = scanner.nextInt();
            processCommand(cmd);
        }
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
        } else if (cmd == 7) {
            setForeign();
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
        boolean foreign = requestForeign();
        int type = requestType();
        current = bank.newAccount(type, foreign);
        System.out.println("Your new account number is " + current);
    }

    /** Requests for foreign/domestic status for bank account. */
    private boolean requestForeign() {
        System.out.print("Enter status (1-foreign, 2-domestic, 3-interest checking): ");
        int answer = scanner.nextInt();
        return answer == 1;
    }

    private int requestType() {
        System.out.print("Enter type (1-savings, 2-checking): ");
        return scanner.nextInt();
    }

    /** Requests and sets foreign/domestic status for the current bank account. */
    private void setForeign() {
        bank.setForeign(current, requestForeign() );
    }

    /** Makes an existing account current and prints the account balance. */
    private void select() {
        System.out.print("Enter account #: ");
        current = scanner.nextInt();
        int balance = bank.getBalance(current);
        System.out.printf("The balance of account %d is %d%n", current, balance);
    }

    /** Increases the balance of the current account by a specified number of cents. */
    private void deposit() {
        System.out.print("Enter deposit amount: ");
        int amt = scanner.nextInt();
        bank.deposit(current, amt);
    }

    /** Determines whether the current account has enough money to be used as collateral for a loan. */
    private void authorizeLoan() {
        System.out.print("Enter loan amount: ");
        int loan = scanner.nextInt();
        boolean authorized = bank.authorizeLoan(current, loan);
        if (authorized) {
            System.out.println("Your loan is approved");
        } else {
            System.out.println("Your loan is denied");
        }
    }

    /** Prints the balance of every account. */
    private void showAll() {
        System.out.println(bank.toString());
    }

    /** Increases the balance of each account by a fixed interest rate. */
    private void addInterest() {
        bank.addInterest();
    }
}
