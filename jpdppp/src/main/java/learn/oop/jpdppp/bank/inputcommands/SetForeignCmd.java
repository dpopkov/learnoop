package learn.oop.jpdppp.bank.inputcommands;

import learn.oop.jpdppp.bank.Bank;
import learn.oop.jpdppp.bank.InputCommand;

import java.util.Scanner;

public class SetForeignCmd implements InputCommand {
    @Override
    public int execute(Scanner scanner, Bank bank, int current) {
        bank.setForeign(current, requestForeign(scanner) );
        return current;
    }

    private boolean requestForeign(Scanner scanner) {
        System.out.print("Enter status (1-foreign, 2-domestic): ");
        int answer = scanner.nextInt();
        return answer == 1;
    }

    @Override
    public String toString() {
        return "set foreign";
    }
}
