package learn.oop.jpdppp.bank.inputcommands;

import learn.oop.jpdppp.bank.Bank;
import learn.oop.jpdppp.bank.InputCommand;

import java.util.Scanner;

public class QuitCmd implements InputCommand {
    @Override
    public int execute(Scanner scanner, Bank bank, int current) {
        System.out.println("Bye!");
        return -1;
    }

    @Override
    public String toString() {
        return "quit";
    }
}
