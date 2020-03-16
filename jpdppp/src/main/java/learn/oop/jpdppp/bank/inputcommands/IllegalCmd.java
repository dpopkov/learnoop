package learn.oop.jpdppp.bank.inputcommands;

import learn.oop.jpdppp.bank.Bank;
import learn.oop.jpdppp.bank.InputCommand;

import java.util.Scanner;

public class IllegalCmd implements InputCommand {
    @Override
    public int execute(Scanner scanner, Bank bank, int current) {
        System.out.println("Illegal command.");
        return current;
    }
}
