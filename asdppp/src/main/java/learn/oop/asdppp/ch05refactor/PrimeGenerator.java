package learn.oop.asdppp.ch05refactor;

import java.util.Arrays;

/**
 * Generates primes to a a user-specified maximum.
 * Uses algorithm Sieve of Eratosthenes.
 */
public class PrimeGenerator {
    private static boolean[] isCrossed;
    private static int[] result;

    public static int[] generate(int maxValue) {
        if (maxValue < 2) {
            return new int[0];
        } else {
            initializeArrayOfIntegers(maxValue);
            crossOutMultiples();
            putUncrossedIntegersIntoResult();
            return result;
        }
    }

    private static void initializeArrayOfIntegers(int maxValue) {
        isCrossed = new boolean[ maxValue + 1];
        Arrays.fill(isCrossed, false);
        isCrossed[0] = isCrossed[1] = true;
    }

    private static boolean notCrossed(int i) {
        return !isCrossed[i];
    }

    private static void crossOutMultiples() {
        int maxPrimeFactor = calcMaxPrimeFactor();
        for (int i = 2; i <= maxPrimeFactor; i++) {
            if (notCrossed(i)) {
                crossOutMultiplesOf(i);
            }
        }
    }

    private static int calcMaxPrimeFactor() {
        double maxPrimeFactor = Math.sqrt(isCrossed.length) + 1;
        return (int) maxPrimeFactor;
    }

    private static void crossOutMultiplesOf(int i) {
        for (int multiple = 2 * i; multiple < isCrossed.length; multiple += i) {
            isCrossed[multiple] = true;
        }
    }

    private static void putUncrossedIntegersIntoResult() {
        result = new int[numberOfUncrossedIntegers()];
        for (int i = 2, j = 0; i < isCrossed.length; i++) {
            if (notCrossed(i)) {
                result[j++] = i;
            }
        }
    }

    private static int numberOfUncrossedIntegers() {
        int count = 0;
        for (int i = 0; i < isCrossed.length; i++) {
            if (notCrossed(i)) {
                count++;
            }
        }
        return count;
    }
}
