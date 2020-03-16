package learn.oop.jpdppp.bank.inputcommands;

import learn.oop.jpdppp.bank.Bank;
import learn.oop.jpdppp.bank.InputCommand;

import java.util.Scanner;

public class InterestCmd implements InputCommand {
    @Override
    public int execute(Scanner scanner, Bank bank, int current) {
        bank.addInterest();
        return current;
    }

    @Override
    public String toString() {
        return "add interest";
    }
}
