package learn.oop.jpdppp.bank;

import java.util.Scanner;

public interface InputCommand {
    /**
     * Execute an action upon the specified bank requesting appropriate input if needed.
     * @param scanner scanner used for user input
     * @param bank bank to act upon
     * @param current number of the current account
     * @return number of the current account that may be changed during the action
     */
    int execute(Scanner scanner, Bank bank, int current);
}
