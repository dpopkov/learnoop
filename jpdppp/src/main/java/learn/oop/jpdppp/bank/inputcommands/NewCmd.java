package learn.oop.jpdppp.bank.inputcommands;

import learn.oop.jpdppp.bank.Bank;
import learn.oop.jpdppp.bank.InputCommand;

import java.util.Scanner;

public class NewCmd implements InputCommand {
    @Override
    public int execute(Scanner scanner, Bank bank, int current) {
        boolean foreign = requestForeign(scanner);
        int type = requestType(scanner);
        int newCurrent = bank.newAccount(type, foreign);
        System.out.println("Your new account number is " + newCurrent);
        return newCurrent;
    }

    private boolean requestForeign(Scanner scanner) {
        System.out.print("Enter status (1-foreign, 2-domestic): ");
        int answer = scanner.nextInt();
        return answer == 1;
    }

    private int requestType(Scanner scanner) {
        System.out.print("Enter type (1-savings, 2-checking, 3-interest checking): ");
        return scanner.nextInt();
    }

    @Override
    public String toString() {
        return "new account";
    }
}
