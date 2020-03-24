package learn.oop.jpdppp.bank;

import java.util.Scanner;

public interface InputCommand {
    /**
     * Execute an action upon the specified controller requesting appropriate input if needed.
     * @param scanner scanner used for user input
     * @param controller bank to act upon
     * @return response of the action
     */
    String execute(Scanner scanner, InputController controller);
}
