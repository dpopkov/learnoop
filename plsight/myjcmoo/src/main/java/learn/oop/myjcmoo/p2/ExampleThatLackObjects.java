package learn.oop.myjcmoo.p2;

public class ExampleThatLackObjects {

    /* This method lacks flexibility. */
    public int sum1(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }

    /* Added later to sum only odd numbers */
    public int sum2(int[] values) {
        int sum = 0;
        for (int value : values) {
            if (value % 2 == 0) {
                sum += value;
            }
        }
        return sum;
    }

    /* Added later to sum odd numbers sometimes. */
    public int sum3(int[] values, boolean oddNumbersOnly) {
        int sum = 0;
        for (int value : values) {
            if (!oddNumbersOnly || value % 2 == 0) {
                sum += value;
            }
        }
        return sum;
    }
    /* This class is the consumer.
    It needs a summation service.
    Consumers should not implement services themselves. */

    public static void main(String[] args) {

    }
}
