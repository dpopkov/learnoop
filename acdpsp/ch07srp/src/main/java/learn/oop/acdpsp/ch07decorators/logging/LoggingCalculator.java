package learn.oop.acdpsp.ch07decorators.logging;

public class LoggingCalculator implements Calculator {
    private Calculator calculator;

    public LoggingCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public int add(int x, int y) {
        System.out.println("x = " + x + ", y = " + y);
        int result = calculator.add(x, y);
        System.out.println("result = " + result);
        return result;
    }
}
