package learn.oop.asdppp.ch05refactor;

import java.util.Arrays;

/**
 * Generates primes to a a user-specified maximum.
 * Uses algorithm Sieve of Eratosthenes.
 */
public class PrimeGenerator {
    private static boolean[] crossedOut;
    private static int[] result;

    public static int[] generate(int maxValue) {
        if (maxValue < 2) {
            return new int[0];
        } else {
            uncrossIntegersUpTo(maxValue);
            crossOutMultiples();
            putUncrossedIntegersIntoResult();
            return result;
        }
    }

    private static void uncrossIntegersUpTo(int maxValue) {
        crossedOut = new boolean[ maxValue + 1];
        Arrays.fill(crossedOut, false);
        crossedOut[0] = crossedOut[1] = true;
    }

    private static void crossOutMultiples() {
        int limit = determineIterationLimit();
        for (int i = 2; i <= limit; i++) {
            if (notCrossed(i)) {
                crossOutMultiplesOf(i);
            }
        }
    }

    private static int determineIterationLimit() {
        /* Every multiple in the array has a prime factor that is less than or equal
        to the square root of the array size, so we don't have to cross out
        multiples of numbers larger than that root. */
        double iterationLimit = Math.sqrt(crossedOut.length) + 1;
        return (int) iterationLimit;
    }

    private static boolean notCrossed(int i) {
        return !crossedOut[i];
    }

    private static void crossOutMultiplesOf(int i) {
        for (int multiple = 2 * i; multiple < crossedOut.length; multiple += i) {
            crossedOut[multiple] = true;
        }
    }

    private static void putUncrossedIntegersIntoResult() {
        result = new int[numberOfUncrossedIntegers()];
        for (int i = 2, j = 0; i < crossedOut.length; i++) {
            if (notCrossed(i)) {
                result[j++] = i;
            }
        }
    }

    private static int numberOfUncrossedIntegers() {
        int count = 0;
        for (int i = 0; i < crossedOut.length; i++) {
            if (notCrossed(i)) {
                count++;
            }
        }
        return count;
    }
}
