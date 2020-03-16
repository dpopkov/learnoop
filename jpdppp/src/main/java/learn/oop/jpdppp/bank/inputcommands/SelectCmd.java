package learn.oop.jpdppp.bank.inputcommands;

import learn.oop.jpdppp.bank.Bank;
import learn.oop.jpdppp.bank.InputCommand;

import java.util.Scanner;

public class SelectCmd implements InputCommand {
    @Override
    public int execute(Scanner scanner, Bank bank, int current) {
        System.out.print("Enter account #: ");
        int newCurrent = scanner.nextInt();
        int balance = bank.getBalance(newCurrent);
        System.out.printf("The balance of account %d is %d%n", newCurrent, balance);
        return newCurrent;
    }

    @Override
    public String toString() {
        return "select";
    }
}
