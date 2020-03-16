package learn.oop.jpdppp.bank;

import learn.oop.jpdppp.bank.inputcommands.*;

import java.util.Scanner;

/**
 * It is responsible for I/O processing.
 */
public class BankClient {
    private final Bank bank;
    private final Scanner scanner;
    private int current = 0;
    private boolean done = false;
    private final InputCommand[] commands = {
            new QuitCmd(),
            new NewCmd(),
            new SelectCmd(),
            new DepositCmd(),
            new LoanCmd(),
            new ShowCmd(),
            new InterestCmd(),
            new SetForeignCmd()
    };
    private final InputCommand illegal = new IllegalCmd();

    public BankClient(Scanner scanner, Bank bank) {
        this.scanner = scanner;
        this.bank = bank;
    }

    public void run() {
        while (!done) {
            System.out.print(constructPromptMessage());
            int cmd = scanner.nextInt();
            processCommand(cmd);
        }
    }

    private String constructPromptMessage() {
        StringBuilder result = new StringBuilder("Enter command (");
        int last = commands.length - 2;
        for (int i = 0; i < last; i++) {
            result.append(i).append("=").append(commands[i]).append(", ");
        }
        result.append(last).append("=").append(commands[last]).append("): ");
        return result.toString();
    }

    private void processCommand(int cmdNum) {
        InputCommand command;
        if (0 <= cmdNum && cmdNum < commands.length) {
            command = commands[cmdNum];
        } else {
            command = illegal;
        }
        current = command.execute(scanner, bank, current);
        if (current < 0) {
            done = true;
        }
    }
}
