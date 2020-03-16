package learn.oop.jpdppp.bank.inputcommands;

import learn.oop.jpdppp.bank.Bank;
import learn.oop.jpdppp.bank.InputCommand;

import java.util.Scanner;

public class LoanCmd implements InputCommand {
    @Override
    public int execute(Scanner scanner, Bank bank, int current) {
        System.out.print("Enter loan amount: ");
        int loan = scanner.nextInt();
        boolean authorized = bank.authorizeLoan(current, loan);
        if (authorized) {
            System.out.println("Your loan is approved");
        } else {
            System.out.println("Your loan is denied");
        }
        return current;
    }

    @Override
    public String toString() {
        return "authorize loan";
    }
}
