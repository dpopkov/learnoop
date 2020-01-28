package learn.oop.acdpsp;

import learn.oop.acdpsp.c03server.MessagePrinter;

public class SimpleDependent {
    public static void main(String[] args) {
        System.out.println("Using dependency form other module.");
        MessagePrinter printer = new MessagePrinter();
        printer.print("This dependent uses dependency.");
    }
}
